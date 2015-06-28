package entity

import core.ImageCache
import core.Implicits._
import generators.Dungeon


/**
 * All things not tile
 * Created by Torri on 3/1/2015.
 */
abstract class Entity(var pos: (Double, Double), var maxHealth: Int, dungeon: Dungeon) {
  var health = maxHealth
  def getImage: Int
  def getImgWidth: Int
  def getImgHeight: Int
  def doTurn: Unit
}

object Entity {
  val spriteSheet = ImageCache.loadImage("spritesheet.png")
}
