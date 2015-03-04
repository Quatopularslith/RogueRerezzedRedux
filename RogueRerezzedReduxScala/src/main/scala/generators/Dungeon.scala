package generators

import entity.{Item, Monster}
import generators.Shape._
import generators.Tile._
import scala.collection.mutable.{ArrayBuffer, Map}
import scala.util.Random

/**
 * Created by Torri on 3/1/2015.
 */
object Dungeon {
  val spawnRoomSize = 5
  val maxSize = 10
  val edges = ArrayBuffer.empty[(Int, Int)]
  private val rand = new Random()

  def fits(shape: Shape, floor: Map[(Int, Int), Tile]) = shape.footprint.forall(t => !floor.contains(t))

  def addShape(feature: Shape, floor: Map[(Int, Int), Tile]): Unit ={
    val dir = for (dx <- List(-1, 1); dy <- List(-1, 1)) yield floor.contains((feature.pos._1 + dx, feature.pos._2 + dy))
    var rot = false
    var dd = (0,0)
    if (dir(0)) {
    } else if (dir(1)) {
      //isDefault
      println("Right side")
    } else if (dir(2)) {
    } else {
      rot = true
    }
    def floorify(pos: (Int, Int)): Unit ={
      floor += (pos -> Floor)
    }
    if(rot){
      feature.verticalFoot.foreach(floorify(_))
    }else{
      feature.footprint.foreach(floorify(_))
    }
  }

  def getEdges(floor: Map[(Int, Int), Tile]) = floor.filterKeys(t => (for (dx <- List(-1, 1); dy <- List(-1, 1)) yield floor.contains((t._1 + dx, t._2 + dy))).contains(false))

  def chooseShape(pos: (Int, Int)): Shape = {
    val check = rand.nextDouble()
    if(check < 0.4){
      new Rect(pos, (rand.nextInt() % maxSize, rand.nextInt() % maxSize))
    }else{
      Hallway(pos, rand.nextInt() % maxSize)
    }
  }

  def populate(floor: Map[(Int, Int), Tile]): Unit = {
    var chosen = rand.shuffle(getEdges(floor).keys).head
    for(i <- 0 to (rand.nextInt() % 100) + 1){
      chosen = rand.shuffle(getEdges(floor).keys).head
      floor(chosen) = Chest(Item.randItems())
    }
    for(i <- 0 to (rand.nextInt() % 100) + 1){
      chosen = rand.shuffle(getEdges(floor).keys).head
      floor(chosen) = MonsterSpawn(Monster.pickRand())
    }
    chosen = rand.shuffle(getEdges(floor).keys).head
    floor(chosen) = Spawn
  }

  def genDungeon(): Map[(Int, Int), Tile] = {
    val floor = Map.empty[(Int, Int), Tile]
    var n = 0
    addShape(new Square((0, 0), spawnRoomSize), floor)
    var stop = false
    var noSpace = 0
    var chosen = rand.shuffle(getEdges(floor).keys).head
    var shape = chooseShape((0,0))
    while(!stop){
      chosen = rand.shuffle(getEdges(floor).keys).head
      shape = chooseShape(chosen)
      if(fits(shape, floor)){
        addShape(shape, floor)
        if (noSpace > 0) noSpace -= 1
      }else{
        noSpace += 1
      }
      if(noSpace > 10){
        stop = true
      }
    }
    populate(floor)
    floor
  }
}