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

  trait Feature {
    val pos: (Int, Int)
    def footprint: List[(Int, Int)]
  }
  case class SquareRoom(override val pos: (Int, Int), size: Int) extends Feature {
    def footprint = (for (x <- pos._1 until (pos._1 + size); y <- pos._2 until (pos._2 + size)) yield (x, y)).toList
  }
}
