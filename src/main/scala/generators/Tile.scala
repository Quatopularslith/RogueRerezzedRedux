package generators

import core.ImageCache
import entity._

/**
 * Created by Torri on 3/1/2015.
 */
trait Tile {
  val toChar: Char
  val imgWidth: Int
  val imgHeight: Int
  val img: Int
  val tileType: String
}

object Tile {

  val sprite = Entity.spriteSheet

  case class Chest(var contents: Array[Item]) extends Tile {
    override val toChar = 'C'
    override val img = ImageCache.loadTextureFromBuffImg(sprite.getSubimage(0, 0, 64, 64))
    override val imgWidth = sprite.getSubimage(0, 0, 64, 64).getWidth
    override val imgHeight = sprite.getSubimage(0, 0, 64, 64).getHeight
    override val tileType = "Chest"
  }

  case class MonsterSpawn(monster: Entity) extends Tile {
    override val toChar = 'M'
    override val img = monster.getImage
    override val imgWidth = monster.getImgWidth
    override val imgHeight = monster.getImgHeight
    override val tileType = "Monster"
  }

  case object Floor extends Tile {
    override val toChar = '#'
    override val img = ImageCache.loadTextureFromBuffImg(sprite.getSubimage(3 * 64, 0, 64, 64))
    override val imgWidth = sprite.getSubimage(3 * 64, 0, 64, 64).getWidth
    override val imgHeight = sprite.getSubimage(3 * 64, 0, 64, 64).getHeight
    override val tileType = "Floor"
  }

  case object Door extends Tile {
    override val toChar = 'D'
    override val img = ImageCache.loadTextureFromBuffImg(sprite.getSubimage(3 * 64, 0, 64, 64))
    override val imgWidth = sprite.getSubimage(3 * 64, 0, 64, 64).getWidth
    override val imgHeight = sprite.getSubimage(3 * 64, 0, 64, 64).getHeight
    override val tileType = "Door"
  }

  case object SecretDoor extends Tile {
    override val toChar = 'S'
    override val img = ImageCache.loadTextureFromBuffImg(sprite.getSubimage(3 * 64, 0, 64, 64))
    override val imgWidth = sprite.getSubimage(3 * 64, 0, 64, 64).getWidth
    override val imgHeight = sprite.getSubimage(3 * 64, 0, 64, 64).getHeight
    override val tileType = "Secret Door"
  }

  case object Spawn extends Tile {
    override val toChar = '@'
    override val img = ImageCache.loadTextureFromBuffImg(sprite.getSubimage(0, 2 * 64, 64, 64))
    override val imgWidth = sprite.getSubimage(0, 2 * 64, 64, 64).getWidth
    override val imgHeight = sprite.getSubimage(0, 2 * 64, 64, 64).getHeight
    override val tileType = "Spawn"
  }

  case object Exit extends Tile {
    override val toChar = 'E'
    override val img = ImageCache.loadTextureFromBuffImg(sprite.getSubimage(3 * 64, 2 * 64, 64, 64))
    override val imgWidth = sprite.getSubimage(3 * 64, 2 * 64, 64, 64).getWidth
    override val imgHeight = sprite.getSubimage(3 * 64, 2 * 64, 64, 64).getHeight
    override val tileType = "Exit"
  }

  case object Blank extends Tile {
    override val toChar = ' '
    override val img = 0
    override val imgWidth = 0
    override val imgHeight = 0
    override val tileType = "Blank"
  }
}