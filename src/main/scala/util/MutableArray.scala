package util

/**
 * Created by Torri on 6/25/2015.
 */
class MutableArray[T] {
  var arr = Array.empty[T]
  def +=(next:T):Unit = {
    val newPath:Array[T] = new Array(arr.length)
    for(i <- 0 until arr.length){
      newPath.update(i,arr(i))
    }
    newPath.update(arr.length, next)
    arr = newPath
  }
  def get(index:Int):T = {
    arr(index)
  }
  def toArray ={
    arr
  }
}