package util.pathFinding

import util.Vector

/**
 * Created by Torri on 6/25/2015.
 */
class Simple extends PathFinder{
  override def makePath(start: (Double, Double), end: (Double, Double), speed: Double, limit: Int): Path = {
    val path = new Path(start)
    var x = start._1
    var y = start._2
    for(a <- 1 to limit){
      val distVec = (new Vector(end._1-x,end._2-y)).getUnit * speed
      x += distVec.x
      y += distVec.y
      path += (x, y)
    }
    path
  }
}
