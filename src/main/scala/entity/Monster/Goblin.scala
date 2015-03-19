package entity.Monster

import java.awt.image.BufferedImage

import graphics.ImageCache

/**
 * Created by torridon on 3/8/15.
 */
class Goblin(pos: (Int, Int)) extends Monster(pos, 10, 10, 10, 0) {
  override def getImage: BufferedImage = ImageCache.loadImage("/spritesheet.png").getSubimage(64, 64, 64, 64)
}
