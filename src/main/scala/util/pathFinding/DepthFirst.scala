package util.pathFinding

import generators.{Door, Dungeon}

/**
 * Does cool and fun stuff for getting from one place to another
 * Created by Torri on 6/25/2015.
 */
class DepthFirst(dungeon: Dungeon) extends PathFinder(dungeon) {
  val simple: Wandering = new Wandering(dungeon)

  override def makePath(start: (Double, Double), end: (Double, Double), speed: Double, limit: Int): Path = {
    val startInt = (start._1.toInt, start._2.toInt)
    var curDoor = {
      //val filt = dungeon.doors.filter(t=> simple.pathExists(start, (t.pos._1.toDouble, t.pos._2.toDouble), dungeon))
      dungeon.doors.sortBy(t => (t.pos._1 - startInt._1) * (t.pos._1 - startInt._1) + (t.pos._2 - startInt._2) * (t.pos._2 - startInt._2)).head
    }
    val endInt = (start._1.toInt, start._2.toInt)
    val endDoor = {
      //val filt = dungeon.doors.filter(t=> simple.pathExists(start, (t.pos._1.toDouble, t.pos._2.toDouble), dungeon))
      dungeon.doors.sortBy(t => (t.pos._1 - startInt._1) * (t.pos._1 - startInt._1) + (t.pos._2 - startInt._2) * (t.pos._2 - startInt._2)).head
    }
    var prevDoor: Door = curDoor
    val path: Path = new Path(start)
    var pos = start
    while (path.length < limit && curDoor != endDoor) {
      path += simple.makePath(pos, (curDoor.pos._1.toDouble, curDoor.pos._2.toDouble), speed, 2 * Dungeon.maxSize)
      pos = path.toArray.last
      val isDoor = curDoor.connected.toArray.filter(p => !p.connected.arr.isEmpty)
      if (isDoor.isEmpty) {
        curDoor = prevDoor
      } else {
        prevDoor = curDoor
        curDoor = isDoor.sortBy(t => t.distTo(endDoor)).head
      }
    }
    path += simple.makePath(pos, end, speed, 50000)
    path
  }
}
