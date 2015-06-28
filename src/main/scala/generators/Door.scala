package generators

import util.MutableArray

/**
 * A very useful thing used to get from one room to another
 * Created by Torri on 6/27/2015.
 */
class Door(val pos:(Int,Int), val secret:Boolean, dungeon: Dungeon){
  val connected = new MutableArray[Door]
  def isConnectedTo(other:Door): Boolean ={
    if(other.pos == pos || math.abs(pos._1-other.pos._1) > Dungeon.maxSize*2 || math.abs(pos._2-other.pos._2) > Dungeon.maxSize*2) return false
    val sameX = other.pos._1 == pos._1
    val slope = {
      if(sameX){
        (other.pos._1 - pos._1)/(other.pos._2-pos._2)
      }else{
        (other.pos._2-pos._2)/(other.pos._1 - pos._1)
      }
    }
    def f(x:Int) = {
      if(sameX){
        slope*(x-pos._2)+pos._1 // x = f(y)
      }else{
        slope*(x-pos._1)+pos._2 // y = f(x)
      }
    }
    val x = {
      if(sameX){
        pos._2
      }else{
        pos._1
      }
    }
    val xx = {
      if(sameX){
        other.pos._2
      }else{
        other.pos._1
      }
    }
    val from:Int = {
      if(x>xx){
        xx
      }else{
        x
      }
    }
    val to:Int = {
      if(x>xx){
        x
      }else{
        xx
      }
    }
    for(x <- from to to){
      if(sameX){
        if(!dungeon.floor.keys.exists(t=> t == (f(x),x))){
          return false
        }
      }else{
        if(!dungeon.floor.keys.exists(t=> t == (x,f(x)))){
          return false
        }
      }
    }
    true
  }
  def distTo(other:Door):Int = (pos._1-other.pos._1)*(pos._1-other.pos._1) + (pos._2-other.pos._2)*(pos._2-other.pos._2)
  def distTo(other:(Int,Int)):Int = (pos._1-other._1)*(pos._1-other._1) + (pos._2-other._2)*(pos._2-other._2)
}
