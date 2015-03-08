package generators

import entity._

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Tile(c: Char) {
  def toChar = c
}

object Tile {

  case class Chest(var contents: Array[Item]) extends Tile('C')

  case class MonsterSpawn(var monster: Entity) extends Tile('M')

  case object Floor extends Tile('#')

  case object Door extends Tile('D')

  case object SecretDoor extends Tile('S')

  case object Spawn extends Tile('@')

  case object Exit extends Tile('E')

  case object Blank extends Tile(' ')

}