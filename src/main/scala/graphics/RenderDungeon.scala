package graphics

import core.Implicits._
import core.{Image, ImageCache, Main}
import generators.Dungeon.dungeon
import generators.{Dungeon, Tile}

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.ArrayBuffer

/**
 * Created by Mnenmenth Alkaborin
 * https://github.com/Mnenmenth
 * Please do not re-distribute without permission
 */



object RenderDungeon{
  var offx = 0
  var offy = 0
  var tileSize = 64

  def setFocus(pos:(Int, Int)): Unit ={
    offx = pos._1 + Main.WINDOW_WIDTH
    offy = pos._2 - Main.WINDOW_HEIGHT
  }

  def xRange = Range.apply(offx / tileSize - 1, (Main.WINDOW_WIDTH + offx) / tileSize + 1)
  def yRange = Range.apply(-(offy / tileSize) - 1, (Main.WINDOW_HEIGHT - offy) / tileSize + 1)

  var renderQueue:ArrayBuffer[QueueItem] = ArrayBuffer.empty[QueueItem]

  def addToQueue(id: Int, pos:(Int,Int), width: Int, height: Int, tileType: String) = renderQueue.+=(new QueueItem(id, pos, width, height, tileType))

  def edges = Dungeon.getEdges(dungeon.floor)

  val chestSubImg = new Image(Tile.sprite.getSubimage(0, 0, 64, 64))
  val chestSprite = new Sprite(ImageCache.loadTextureFromBuffImg(chestSubImg.image), chestSubImg.width, chestSubImg.height)

  val floorSubImg = new Image(Tile.sprite.getSubimage(3 * 64, 0, 64, 64))
  val floorSprite = new Sprite(ImageCache.loadTextureFromBuffImg(chestSubImg.image), floorSubImg.width, floorSubImg.height)

  val doorSubImg = new Image(Tile.sprite.getSubimage(4 * 64, 0, 64, 64))
  val doorSprite = new Sprite(ImageCache.loadTextureFromBuffImg(doorSubImg.image), doorSubImg.width, doorSubImg.height)

  val secretDoorSubImg = new Image(Tile.sprite.getSubimage(4 * 64, 64, 64, 64))
  val secretDoorSprite = new Sprite(ImageCache.loadTextureFromBuffImg(secretDoorSubImg.image), secretDoorSubImg.width, secretDoorSubImg.height)

  val spawnSubImg = new Image(Tile.sprite.getSubimage(3 * 64, 0, 64, 64))
  val spawnSprite = new Sprite(ImageCache.loadTextureFromBuffImg(spawnSubImg.image), spawnSubImg.width, spawnSubImg.height)

  val exitSubImg = new Image(Tile.sprite.getSubimage(3 * 64, 2 * 64, 64, 64))
  val exitSprite = new Sprite(ImageCache.loadTextureFromBuffImg(exitSubImg.image), exitSubImg.width, exitSubImg.height)

  val playerSubImg = new Image(ImageCache.loadImage("spritesheet.png").getSubimage(0, 2*64, 64, 64))
  val playerSprite = new Sprite(ImageCache.loadTextureFromBuffImg(playerSubImg.image), playerSubImg.width, playerSubImg.height)

  val goblinSubImg = new Image(ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64))
  val goblinSprite = new Sprite(ImageCache.loadTextureFromBuffImg(goblinSubImg.image), goblinSubImg.width, goblinSubImg.height)

  val blank = new Sprite(9000, 0, 0)

  val spriteArray: Array[Sprite]= Array(
    blank,//blank
    chestSprite,//chest
    floorSprite,//floor
    doorSprite,//door
    secretDoorSprite,//secret door
    spawnSprite,//spawn (missing tex)
    exitSprite,//exit
    playerSprite, //player
    goblinSprite) //goblin

  def render() {
    renderQueue.foreach{qi =>
      val sprite = spriteArray(qi.getId)
      System.out.println(sprite.texid)
      sprite.setPos(qi.getPos.x, qi.getPos.y)
      sprite.draw()
    }
    renderQueue = ArrayBuffer.empty[QueueItem]
  }

  def floorQueue(): Unit ={
    dungeon.floor.filterKeys(p => xRange.contains(p.x) && yRange.contains(p.y)).foreach{t =>
      addToQueue(Tile.Floor.id, (t._1.x * tileSize - offx, t._1.y * tileSize + offy), tileSize, tileSize, Tile.Floor.tileType)
      addToQueue(t._2.id, (t._1.x * tileSize - offx, t._1.y * tileSize + offy), tileSize, tileSize, t._2.tileType)
    }
  }

  def entityQueue(): Unit ={
    dungeon.entities.filter(e=> xRange.contains(e.pos.x) && yRange.contains(e.pos.y)).foreach{t =>
      addToQueue(t.getId, ((t.pos._1 * tileSize - offx).toInt, (t.pos._2 * tileSize + offy).toInt), tileSize, tileSize, "Entity thing")
    }
  }

  class QueueItem(id: Int, pos: (Int, Int), width: Int, height: Int, tile: String){
    def getId = id
    def getPos = pos
    def getWidth = width
    def getHeight = height
    def tileType = tile
  }
}