package util.pathFinding

import generators.Dungeon
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
      val distVec = new Vector(end._1-x,end._2-y).getUnit * speed
      x += distVec.x
      y += distVec.y
      path += (x, y)
      if((x-end._1)*(x-end._1) + (y-end._2)*(y-end._2) <= 1) return path
    }
    path
  }
  def pathExists(start: (Double,Double), end: (Double, Double), dungeon: Dungeon): Boolean ={
    val slope = (end._2 - start._2)/(end._1 - start._1)
    def f(x:Int) = slope*(x-start._1)+start._2
    val from:Int = {
      if(start._1>end._1){
        end._1.toInt
      }else{
        start._1.toInt
      }
    }
    val to:Int = {
      if(start._1>end._1){
        start._1.toInt
      }else{
        end._1.toInt
      }
    }
    if(from-to > Dungeon.maxSize*2) return false
    for(x <- from to to){
      if(!dungeon.floor.keys.exists(t=> t == (x,f(x)))){
        return false
      }
    }
    true
  }
}
