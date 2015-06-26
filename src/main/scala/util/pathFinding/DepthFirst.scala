package util.pathFinding

import generators.{Tile, Dungeon}
import util.MutableArray

/**
 * Created by Torri on 6/25/2015.
 */
class DepthFirst(val dungeon: Dungeon) extends  PathFinder{
  override def makePath(start: (Double, Double), end: (Double, Double), speed: Double, limit: Int): Path = {
    val doors: List[((Int, Int), Tile)] = dungeon.getAllof(Tile.Door)

    val startInt = (start._1.toInt, start._2.toInt)
    val startDoor = {
      doors.sortBy(t => t._1._1 - startInt._1).sortBy(t => t._1._2 - startInt._2)
    }
    val endInt = (start._1.toInt, start._2.toInt)
    val endDoor = {
      doors.sortBy(t => t._1._1 - endInt._1).sortBy(t => t._1._2 - endInt._2)
    }


  }
  class Node(val value:Double){
    val children:MutableArray[Node] = new MutableArray[Node]
    def +=(child:Node): Unit ={
      children += child
    }
  }
}
