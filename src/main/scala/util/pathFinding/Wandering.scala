package util.pathFinding

import util.Vector

import scala.math._

/**
 * Gotta go somewhere? Lemme go to the shops first.
 * Created by Torri on 6/27/2015.
 */
class Wandering extends Simple{
  val rand = new scala.util.Random
  override def makePath(start: (Double, Double), end: (Double, Double), speed: Double, limit: Int): Path = {
    val path = new Path(start)
    var x = start._1
    var y = start._2
    var distVec:Vector = null
    for(a <- 1 to limit){
      if(rand.nextBoolean){
        val theta = (rand.nextInt(359)*Pi)/180
        distVec = new Vector(cos(theta),sin(theta)).getUnit * speed
      }else{
        distVec = new Vector(end._1-x,end._2-y).getUnit * speed
      }
      x += distVec.x
      y += distVec.y
      path += (x, y)
      if((x-end._1)*(x-end._1) + (y-end._2)*(y-end._2) <= 1) return path
    }
    path
  }
}
