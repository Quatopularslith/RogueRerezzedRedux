package entity.Monster

import java.awt.image.BufferedImage

import core.ImageCache._

/**
 * Created by torridon on 3/8/15.
 */
class Goblin(pos: (Int, Int)) extends Monster(pos, 10, 10, 10, 0) {
  override def getImage: BufferedImage = loadImage("/spritesheet.png").getSubimage(16, 16, 16, 16)
}
