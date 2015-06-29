package graphics

import core.Implicits._
import core.{Image, ImageCache, Main}
import generators.{Dungeon, Tile}
import generators.Dungeon.dungeon

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


  var spriteArray = Array(
    0,//blank
    ImageCache.loadTextureFromBuffImg(Tile.sprite.getSubimage(0, 0, 64, 64)),//chest
    ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64)),//goblin
    ImageCache.loadTextureFromBuffImg(Tile.sprite.getSubimage(3 * 64, 0, 64, 64)),//floor
    ImageCache.loadTextureFromBuffImg(Tile.sprite.getSubimage(4 * 64, 0, 64, 64)),//door
    ImageCache.loadTextureFromBuffImg(Tile.sprite.getSubimage(4 * 64, 64, 64, 64)),//secret door
    ImageCache.loadTextureFromBuffImg(Tile.sprite.getSubimage(4 * 64, 2 * 64, 64, 64)),//spawn
    ImageCache.loadTextureFromBuffImg(Tile.sprite.getSubimage(3 * 64, 2 * 64, 64, 64)))//exit

  def render() {
    renderQueue.foreach{qi =>
      val img = new Image(spriteArray(qi.getId), qi.getWidth, qi.getHeight)
      img.setPos(qi.getPos.x, qi.getPos.y)
      img.draw
      if(qi.tileType.equals("Spawn")) System.out.println(qi.getPos)
    }
    renderQueue = ArrayBuffer.empty[QueueItem]
  }

  def floorQueue(): Unit ={
    dungeon.floor.filterKeys(p => xRange.contains(p.x) && yRange.contains(p.y)).foreach{t =>
      addToQueue(Tile.Floor.id, (t._1.x * tileSize - offx, t._1.y * tileSize + offy), Tile.Floor.imgWidth, Tile.Floor.imgHeight, Tile.Floor.tileType)
      addToQueue(t._2.id, (t._1.x * tileSize - offx, t._1.y * tileSize + offy), t._2.imgWidth, t._2.imgHeight, t._2.tileType)
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