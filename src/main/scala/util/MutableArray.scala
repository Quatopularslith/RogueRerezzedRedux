package util

/**
 * Because I didn't want to look up documentation
 * Created by Torri on 6/25/2015.
 */
class MutableArray[T: Manifest] {
  var arr: Array[T] = Array.empty[T]

  def +=(next: T): Unit = {
    val newPath: Array[T] = new Array(arr.length + 1)
    for (i <- 0 until arr.length) {
      newPath.update(i, arr(i))
    }
    newPath.update(arr.length, next)
    arr = newPath
  }

  def +=(next: List[T]): Unit = {
    next.foreach(t => this += t)
  }

  def +=(next: MutableArray[T]): Unit = {
    next.arr.foreach(t => this += t)
  }

  def +(mutableArray: MutableArray[T]): MutableArray[T] = {
    this += mutableArray.toArray.toList
    this
  }

  def +(array: List[T]): MutableArray[T] = {
    this += array
    this
  }

  def get(index: Int): T = {
    arr(index)
  }

  def exists(isThere: T): Boolean = {
    arr.contains(isThere)
  }

  def length = arr.length

  def toArray = arr
}