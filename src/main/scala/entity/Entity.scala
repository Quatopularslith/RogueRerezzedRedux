package entity

import core.ImageCache
import core.Implicits._


/**
 * All things not tile
 * Created by Torri on 3/1/2015.
 */
abstract class Entity(var pos: (Double, Double), var maxHealth: Int) {
  var health = maxHealth
  def getImage: Int
  def getImgWidth: Int
  def getImgHeight: Int
}

object Entity {
  val spriteSheet = ImageCache.loadImage("spritesheet.png")
}
