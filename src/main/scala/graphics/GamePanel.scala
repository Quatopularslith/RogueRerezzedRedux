package graphics

/*
* Created by Mnenmenth
*/

import java.awt.Rectangle

import core.Implicits.SuperTuple
import core.Main
import generators.{Dungeon, Tile}

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.ArrayBuffer

object GamePanel{

  var viewport = new Rectangle(0, 0, 1600, 900)

  val dungeon = Dungeon.genDungeon(20)


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

  def addToQueue(img: Int, pos:(Int,Int), width: Int, height: Int) = renderQueue.+=(new QueueItem(img, pos, width, height))

  def edges = Dungeon.getEdges(dungeon.floor)

  def render() {
    renderQueue.foreach{qi =>
      val img = new BuffImg(qi.getImg, qi.getPos.x, qi.getPos.y, qi.getWidth, qi.getHeight)
      img.draw
    }
    renderQueue = ArrayBuffer.empty[QueueItem]
  }

  def floorQueue(): Unit ={
        dungeon.floor.filterKeys(p => xRange.contains(p.x) && yRange.contains(p.y)).foreach{t =>
          GamePanel.addToQueue(Tile.Floor.img, (t._1.x * tileSize - offx, t._1.y * tileSize + offy), Tile.Floor.imgWidth, Tile.Floor.imgHeight)
          GamePanel.addToQueue(t._2.img, (t._1.x * tileSize - offx, t._1.y * tileSize + offy), t._2.imgWidth, t._2.imgHeight)
        }

  }

  class QueueItem(img: Int, pos: (Int, Int), width: Int, height: Int){
    def getImg = img
    def getPos = pos
    def getWidth = width
    def getHeight = height
  }
}