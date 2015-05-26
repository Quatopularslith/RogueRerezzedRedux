package entity

import core.ImageCache
import core.Implicits._


/**
 * Created by Torri on 3/1/2015.
 */
abstract class Entity(var pos: (Int, Int), var maxHealth: Int) {
  var health = maxHealth

  def move(distance: (Int, Int)): Unit = pos += distance

  def getImage: Int
  def getImgWidth: Int
  def getImgHeight: Int
}

object Entity {
  val spriteSheet = ImageCache.loadImage("spritesheet.png")
}
