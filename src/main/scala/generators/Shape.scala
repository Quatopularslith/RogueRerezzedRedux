package generators

import core.Implicits._
import scala.collection.mutable.ArrayBuffer

/**
 * Gee I'm a Tree
 * Created by Torri on 3/1/2015.
 */
trait Shape {
  val pos: (Int, Int)

  def footprint: List[(Int, Int)]

  def transpose = Shape(pos, footprint.map(_.swap))

  def test = Shape(pos, Shape.getTestFoot(pos, footprint))
}

object Shape {

  case class Rect(override val pos: (Int, Int), size: (Int, Int)) extends Shape {
    override def footprint = (for (x <- 0 until size._1; y <- 0 until size._2) yield (x, y) + pos).toList
  }

  def apply(p: (Int, Int), fp: List[(Int, Int)]): Shape = new Shape {
    override val pos = p

    override def footprint = fp
  }

  def getTestFoot(p: (Int, Int), fp: List[(Int, Int)]) = {
    val EdgeOffsets = Set((1, 0), (0, 1), (-1, 0), (0, -1))
    val edges = fp.flatMap(t => EdgeOffsets.map(off => t + off)).distinct
    var m: ArrayBuffer[(Int, Int)] = new ArrayBuffer(1)
    edges.foreach(m += _)
    fp.foreach(m += _)
    m.sortBy(_._1)
    m.sortBy(_._2)
    m.toList
  }


  def Square(pos: (Int, Int), width: Int) = Rect(pos, (width, width))

  def Hallway(pos: (Int, Int), length: Int) = Rect(pos, (2, length))

  case class Circle(override val pos: (Int, Int), radius: Int) extends Shape {
    override def footprint = (for (x <- -radius to radius; y <- -radius to radius if x * x + y * y <= radius * radius) yield (x, y) + pos).toList
  }

}
