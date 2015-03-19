package entity

import java.awt.image.BufferedImage
import graphics.Spritesheet
import core.Implicits._

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Entity(var pos: (Int, Int), var maxHealth: Int) {
  var health = maxHealth

  def move(distance: (Int, Int)): Unit = pos += distance

  def getImage: BufferedImage
}

object Entity {
  val spriteSheet = new Spritesheet("spritesheet.png")
}
