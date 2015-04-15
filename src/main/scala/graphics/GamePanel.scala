package graphics

/*
* Created by Mnenmenth
*/

import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.util
import java.util.{Timer, TimerTask}

import core.Implicits.SuperTuple
import core.Main
import generators.{Dungeon, Tile}
import org.newdawn.slick.Image

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.swing.Panel

object GamePanel{

  var renderQueue:ArrayBuffer[QueueItem] = ArrayBuffer.empty[QueueItem]

  def addToQueue(img: Image, pos:(Int,Int),args: Array[Int]) = renderQueue.+=(new QueueItem(img, pos))
  def addToQueue(img: Image, pos:(Int,Int)) = renderQueue.+=(new QueueItem(img, pos))

  def render() {
    renderQueue.foreach(qi => qi.getImg.draw(qi.getPos._1, qi.getPos._2))
    renderQueue = ArrayBuffer.empty[QueueItem]
  }

  class QueueItem(img: Image, pos: (Int, Int)){
    def getImg = img
    def getPos = pos
  }
}