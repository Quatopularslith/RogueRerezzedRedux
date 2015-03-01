package generators

/**
 * Created by Torri on 3/1/2015.
 */
object Tiles {
  abstract class Tile(c: Char) { def toChar = c }
  case object Floor extends Tile('#')
  case object Door extends Tile('D')
  case class Chest(var contents: Any*) extends Tile('C')
  case object SecretDoor extends Tile('S')
  case object Spawn extends Tile('$')
  case class MonsterSpawn(var monster: Any*) extends Tile('M')

  trait Shape {
    val pos: (Int, Int)
    def footprint: List[(Int, Int)]
    def flipFoot = footprint.map(_.swap)
  }
  case class Rect(override val pos: (Int, Int), size: (Int, Int)) extends Shape {
    def footprint = (for (x <- pos._1 until (pos._1 + size._1); y <- pos._2 until (pos._2 + size._2)) yield (x, y)).toList
  }
  case class Square(override val pos: (Int, Int), width: Int) extends Rect(pos, (width, width))
  case class Hallway(override val pos: (Int, Int), length: Int) extends Rect(pos, (1, length))
}