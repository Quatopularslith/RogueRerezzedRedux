package generators

import util.MutableArray

/**
 * Created by Torri on 6/27/2015.
 */
class Door(val pos:(Int,Int), val secret:Boolean, dungeon: Dungeon){
  val connected = new MutableArray[Door]
  def isConnectedTo(other:Door): Boolean ={
    val slope = (other.pos._2-pos._2)/(other.pos._1 - pos._1)
    def f(x:Int) = slope*(x-pos._1)+pos._2
    val from:Int = {
      if(pos._1>other.pos._1){
        other.pos._1
      }else{
        pos._1
      }
    }
    val to:Int = {
      if(pos._1>other.pos._1){
        pos._1
      }else{
        other.pos._1
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
  def distTo(other:Door):Int = (pos._1-other.pos._1)*(pos._1-other.pos._1) + (pos._2-other.pos._2)*(pos._2-other.pos._2)
  def distTo(other:(Int,Int)):Int = (pos._1-other._1)*(pos._1-other._1) + (pos._2-other._2)*(pos._2-other._2)
}
