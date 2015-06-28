package util.pathFinding

import generators.Dungeon
import util.Vector

import scala.math._

/**
 * Gotta go somewhere? Lemme go to the shops first.
 * Created by Torri on 6/27/2015.
 */
class Wandering(dungeon: Dungeon) extends Simple(dungeon) {
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
      val xRange = (x + distVec.x - 1).toInt to (x + distVec.x + 1).toInt
      val yRange = (y + distVec.y - 1).toInt to (y + distVec.y + 1).toInt
      if(dungeon.floor.keys.exists(t=> xRange.contains(t._1))){
        x += distVec.x
      }
      if(dungeon.floor.keys.exists(t=> yRange.contains(t._2))){
        y += distVec.y
      }
      path += (x, y)
      if((x-end._1)*(x-end._1) + (y-end._2)*(y-end._2) <= 1) return path
    }
    path
  }
}
