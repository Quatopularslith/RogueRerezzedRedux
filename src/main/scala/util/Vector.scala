package util

/**
 * Created by Torri on 6/18/2015.
 */
class Vector(var x:Double, var y:Double) {
  def *(vector: Vector):Double = {//Dot Product
    x*vector.x+y*vector.y
  }

  def *(scalar: Double):Vector = {
    new Vector(x * scalar, y * scalar)
  }
  def /(scalar: Double):Vector = {
    new Vector(x / scalar, y / scalar)
  }

  def length():Double = {
    math.sqrt(x*x + y*y)
  }
  def getUnit(): Vector = {
    this / length
  }
}
