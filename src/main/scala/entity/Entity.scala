package entity

import generators.Dungeon
import graphics.ImageCache


/**
 * All things not tile
 * Created by Torri on 3/1/2015.
 */
abstract class Entity(inipos: (Double, Double), var maxHealth: Int, dungeon: Dungeon) {
  var health = maxHealth
  var pos = inipos

  def setPos(newPos: (Double, Double)): Unit = {
    pos = newPos
  }

  def getId: Int

  def getImgWidth: Int

  def getImgHeight: Int

  def doTurn: Unit
}

object Entity {
  val spriteSheet = ImageCache.loadImage("spritesheet.png")
}
