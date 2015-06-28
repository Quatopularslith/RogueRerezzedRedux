package util.pathFinding

import util.Vector

import scala.math._

/**
 * Created by Torri on 6/25/2015.
 */
class Random extends PathFinder{
  override def makePath(start: (Double, Double), end: (Double, Double), speed: Double, limit: Int): Path = {
    val path = new Path(start)
    val rand = new scala.util.Random()
    var x = start._1
    var y = start._2
    for(a <- 1 to limit){
      val theta = (rand.nextInt(359)*Pi)/180
      val dirVec = (new Vector(cos(theta),sin(theta))).getUnit * speed
      x += dirVec.x
      y += dirVec.y
      path += (x,y)
    }
    path
  }
}
