package generators

import core.Implicits._

/**
 * Created by Torri on 3/1/2015.
 */
trait Shape {
  val pos: (Int, Int)

  def footprint: List[(Int, Int)]

  def transpose = Shape(pos, footprint.map(_.swap))
}

object Shape {

  case class Rect(override val pos: (Int, Int), size: (Int, Int)) extends Shape {
    override def footprint = (for (x <- 0 until size._1; y <- 0 until size._2) yield (x, y) + pos).toList
  }

  def apply(p: (Int, Int), fp: List[(Int, Int)]): Shape = new Shape {
    override val pos = p

    override def footprint = fp
  }

  def Square(pos: (Int, Int), width: Int) = Rect(pos, (width, width))

  def Hallway(pos: (Int, Int), length: Int) = Rect(pos, (1, length))

  case class Circle(override val pos: (Int, Int), radius: Int) extends Shape {
    override def footprint = (for (x <- -radius to radius; y <- -radius to radius if x * x + y * y <= radius * radius) yield (x, y) + pos).toList
  }

}
