package generators

import java.awt.image.BufferedImage

import entity._
import graphics.Spritesheet
import org.newdawn.slick.Image
import graphics.ImageCache

/**
 * Created by Torri on 3/1/2015.
 */
trait Tile {
  val toChar: Char
  val img: Image
}

object Tile {

  var sprite = ImageCache.loadSlickImg("/spritesheet.png")

  case class Chest(var contents: Array[Item]) extends Tile {
    override val toChar = 'C'
    override val img = sprite.getSubImage(0, 0, 64, 64)
  }

  case class MonsterSpawn(monster: Entity) extends Tile {
    override val toChar = 'M'
    override val img = monster.getImage
  }

  case object Floor extends Tile {
    override val toChar = '#'
    override val img = sprite.getSubImage(3 * 64, 0, 64, 64)
  }

  case object Door extends Tile {
    override val toChar = 'D'
    override val img = sprite.getSubImage(3 * 64, 0, 64, 64)
  }

  case object SecretDoor extends Tile {
    override val toChar = 'S'
    override val img = sprite.getSubImage(3 * 64, 0, 64, 64)
  }

  case object Spawn extends Tile {
    override val toChar = '@'
    override val img = sprite.getSubImage(0, 2 * 64, 64, 64)
  }

  case object Exit extends Tile {
    override val toChar = 'E'
    override val img = sprite.getSubImage(3 * 64, 2 * 64, 64, 64)
  }

  case object Blank extends Tile {
    override val toChar = ' '
    override val img = null
  }
}