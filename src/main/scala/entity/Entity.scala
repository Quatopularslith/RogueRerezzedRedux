package entity

import java.awt.image.BufferedImage
import graphics.{ImageCache, Spritesheet}
import core.Implicits._
import org.newdawn.slick.Image


/**
 * Created by Torri on 3/1/2015.
 */
abstract class Entity(var pos: (Int, Int), var maxHealth: Int) {
  var health = maxHealth

  def move(distance: (Int, Int)): Unit = pos += distance

  def getImage: Image
}

object Entity {
  val spriteSheet = ImageCache.loadSlickImg("spritesheet.png")
}
