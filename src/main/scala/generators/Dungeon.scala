package generators

import core.Implicits._
import entity.Item
import entity.Monster.Monster
import generators.Shape._
import generators.Tile._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Created by Torri on 3/1/2015.
 */
class Dungeon(var floor: mutable.Map[(Int, Int), Tile]) {
  override def toString: String = {
    val xs = floor.keys.map(_._1)
    val bounds = xs.min to xs.max
    floor.groupBy(_._1.y).mapValues(_.map({ case (pos, tile) => (pos._1, tile) })).mapValues(row => {
      val missing = bounds.filter(x => !row.keySet.contains(x)).map((_, Blank))
      (row ++ missing).toList.sortBy(_._1).map(_._2.toChar).mkString(" ")
    }).toList.sortBy(_._1).map(_._2).mkString("\n")
  }
}

object Dungeon {
  def percentComplete = (100 * comP / numR).toString

  var numR: Int = 1
  var comP: Int = 0

  var doneYet = false

  val spawnRoomSize = 5
  val maxSize = 20
  val edges = ArrayBuffer.empty[(Int, Int)]
  val EdgeOffsets = Set((1, 0), (0, 1), (-1, 0), (0, -1))
  val rand = new Random()

  def roundTo(d: Double, decPlace: Int): Double = {
    val sto = d * math.pow(10, decPlace.toDouble)
    math.round(sto).toDouble / math.pow(10, decPlace.toDouble)
  }

  def genDungeon(roomCount: Int): Dungeon = {
    val thread = new Thread {
      numR = roomCount
      val floor = mutable.Map.empty[(Int, Int), Tile]
      var n = 0

      override def run() {
        addShape(Circle((0, 0), spawnRoomSize), floor)
        while (n < roomCount) {
          comP = n
          println(percentComplete)
          val chosen = rand.shuffle(getEdges(floor)).head
          val shape = chooseShape(chosen._2)
          val accepted = jiggle(floor, chosen._2, shape).orElse(jiggle(floor, chosen._2, shape.transpose))
          accepted.map(fitShape => {
            val doorType = if (rand.nextDouble() > 0.9) SecretDoor else Door
            floor += (chosen._1 -> doorType)
            addShape(fitShape, floor)
            n += 1
          })
        }
        //println(s"Actual Rooms: $n")
        populate(floor, n)
        join();
      }
    }
    thread.start()
    doneYet = true
    new Dungeon(thread.floor)
  }

  def addShape(feature: Shape, floor: mutable.Map[(Int, Int), Tile]): Unit = {
    feature.footprint.foreach(pos => floor += (pos -> Floor))
  }

  def getEdges(floor: mutable.Map[(Int, Int), Tile]) = {
    floor.keys.flatMap(t => EdgeOffsets.map(off => (t + off, t + off + off)).filter(pos => !floor.contains(pos._1) && !floor.contains(pos._2))).toList.distinct
  }

  def chooseShape(pos: (Int, Int)): Shape = {
    rand.nextDouble() match {
      case x if x > 0.60 => Rect(pos, (rand.nextInt(maxSize) + 2, rand.nextInt(maxSize) + 2))
      case y if y > 0.55 => Circle(pos, rand.nextInt(maxSize / 2) + 1)
      case _ => Hallway(pos, rand.nextInt(maxSize) + maxSize / 5)
    }
  }

  def populate(floor: mutable.Map[(Int, Int), Tile], roomCount: Int): Unit = {
    val chestCount = rand.nextInt(roomCount / 2) + 1
    for (i <- 0 to chestCount) {
      floor += setRandom(floor) -> Chest(Item.randItems())
    }
    val tileCount = floor.keys.size
    val monsterCount = rand.nextInt(tileCount / 25) + tileCount / 50
    for (i <- 0 to monsterCount) {
      val pos = setRandom(floor)
      floor += pos -> MonsterSpawn(Monster.pickRand(pos))
    }
    floor += setRandom(floor) -> Spawn
    floor += setRandom(floor) -> Exit
  }

  def setRandom(floor: mutable.Map[(Int, Int), Tile]) = {
    val floorTiles = floor.filter(_._2 == Floor).keys.toList
    rand.shuffle(floorTiles).head
  }

  def jiggle(floor: mutable.Map[(Int, Int), Tile], pos: (Int, Int), shape: Shape) = {
    val minX = floor.keys.map(_._1).min
    val minY = floor.keys.map(_._2).min
    val shiftedFootprint = rand.shuffle(shape.footprint.map(_ -(minX, minY)))
    val fit = Stream.apply(shiftedFootprint: _*).map(off => {
      val test = shiftedFootprint.map(_ + pos - off)
      val testShape = Shape(pos, test)
      if (fits(Shape(pos, testShape.test.footprint), floor)) Some(Shape(pos - off, test)) else None
    }).dropWhile(!_.isDefined)
    if (fit.nonEmpty) fit.head else None
  }

  def fits(shape: Shape, floor: mutable.Map[(Int, Int), Tile]) = shape.footprint.forall(t => !floor.contains(t))
}