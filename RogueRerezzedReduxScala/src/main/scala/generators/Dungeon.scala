package generators

import generators.Shape._
import scala.collection.mutable.{ArrayBuffer, Map}
import scala.util.Random

/**
 * Created by Torri on 3/1/2015.
 */
object Dungeon {
  val spawnRoomSize = 5
  val edges = ArrayBuffer.empty[(Int, Int)]
  private val rand = new Random()

  def addShape(feature: Feature, floor: Map[(Int, Int), Tile]): Unit ={
    if(feature.footprint.forall(t => floor.contains(t))){
      return
    }
    def floorify(pos: (Int, Int)): Unit ={
      floor += (pos -> Floor)
    }
    feature.footprint.foreach(floorify(_))
  }

  def getEdges(floor: Map[(Int, Int), Tile]) = floor.filterKeys(t => (for (dx <- List(-1, 1); dy <- List(-1, 1)) yield floor.contains((t._1 + dx, t._2 + dy))).contains(false))

  def genDungeon(size: (Int, Int)):Map[(Int, Int), Tile] = {
    val floor = Map.empty[(Int, Int), Tile]
    addShape(new SquareRoom((size._1 / 2,size._2 / 2), spawnRoomSize), floor)

    while(true){
      val chosen = rand.shuffle(getEdges(floor).keys).head
    }

    return null
  }
}