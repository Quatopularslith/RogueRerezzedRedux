package generators

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Tile(c: Char) { def toChar = c }
object Tile {
  case object Floor extends Tile('#')
  case object Door extends Tile('D')
  case class Chest(var contents: Any*) extends Tile('C')
  case object SecretDoor extends Tile('S')
  case object Spawn extends Tile('$')
  case class MonsterSpawn(var monster: Any*) extends Tile('M')
}