package entity

import java.awt.image.BufferedImage

import core.Implicits._

/**
 * Created by Torri on 3/1/2015.
 */
abstract class Entity(var pos: (Int, Int), val maxHealth: Int) {
  var health = maxHealth

  def move(distance: (Int, Int)): Unit = pos + distance

  def getImage: BufferedImage
}
