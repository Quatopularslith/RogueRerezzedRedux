package graphics

/*
* Created by Mnenmenth
*/

import java.awt.{Font, Rectangle, Graphics2D}
import java.awt.image.BufferedImage
import java.util
import java.util.{Timer, TimerTask}

import core.Implicits.SuperTuple
import core.Main
import generators.{Dungeon, Tile}
import org.newdawn.slick.{TrueTypeFont, Image}
import org.newdawn.slick.tiled.TiledMap

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.swing.Panel

object GamePanel{
  var offx = 0
  var offy = 0
  var tileSize = 64

  def xRange = Range.apply(offx / tileSize - 1, (Main.width + offx) / tileSize + 1)
  def yRange = Range.apply(-(offy / tileSize) - 1, (Main.height - offy) / tileSize + 1)

  var viewport = new Rectangle(0, 0, 1600, 900)

  var renderQueue:ArrayBuffer[QueueItem] = ArrayBuffer.empty[QueueItem]

  val dungeon = Dungeon.genDungeon(100)

  def addToQueue(img: Image, pos:(Int,Int)) = renderQueue.+=(new QueueItem(img, pos))
  //def addToQueue(img: Image, pos:(Int,Int)) = renderQueue.+=(new QueueItem(img, pos))

  def render() {
    renderQueue.foreach(qi => qi.getImg.draw(qi.getPos._1, qi.getPos._2))
    renderQueue = ArrayBuffer.empty[QueueItem]
  }

  def floorQueue(): Unit ={
    GamePanel.dungeon.floor.filterKeys(p => xRange.contains(p.x) && yRange.contains(p.y)).foreach(t => {
      GamePanel.addToQueue(Tile.Floor.img, (t._1.x * tileSize - offx, t._1.y * tileSize + offy))
      GamePanel.addToQueue(t._2.img, (t._1.x * tileSize - offx, t._1.y * tileSize + offy))
    })
  }

  class QueueItem(img: Image, pos: (Int, Int)){
    def getImg = img
    def getPos = pos
  }
}