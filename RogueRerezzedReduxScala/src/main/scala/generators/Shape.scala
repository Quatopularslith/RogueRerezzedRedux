package generators

/**
 * Created by Torri on 3/1/2015.
 */
trait Shape {
  val pos: (Int, Int)
  def footprint: List[(Int, Int)]
  def flipFoot = footprint.map(_.swap)
}
object Shape {
  case class Rect(override val pos: (Int, Int), size: (Int, Int)) extends Shape {
    def footprint = (for (x <- pos._1 until (pos._1 + size._1); y <- pos._2 until (pos._2 + size._2)) yield (x, y)).toList
  }
  case class Square(override val pos: (Int, Int), width: Int) extends Rect(pos, (width, width))
  case class Hallway(override val pos: (Int, Int), length: Int) extends Rect(pos, (1, length))
}
