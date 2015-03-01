package generators

import entity.{Monster, Item}
import generators.Tile._
import generators.Shape._
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
    def floorify(pos: (Int, Int)): Unit ={
      floor += (pos -> Floor)
    }
    feature.footprint.foreach(floorify(_))
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

  def genDungeon(size: (Int, Int)):Map[(Int, Int), Tile] = {
    val floor = Map.empty[(Int, Int), Tile]
    addShape(new Square((size._1 / 2,size._2 / 2), spawnRoomSize), floor)
    var stop = false
    var noSpace = 0
    var chosen = rand.shuffle(getEdges(floor).keys).head
    var shape = chooseShape((0,0))
    while(!stop){
      chosen = rand.shuffle(getEdges(floor).keys).head
      shape = chooseShape(chosen)
      if(fits(shape, floor)){
        addShape(shape, floor)
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