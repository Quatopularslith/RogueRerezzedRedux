package entity.Monster

import java.awt.image.BufferedImage

import graphics.ImageCache
import org.newdawn.slick.Image

/**
 * Created by torridon on 3/8/15.
 */
class Goblin(pos: (Int, Int)) extends Monster(pos, 10, 10, 10, 0) {
  override def getImage: Image = ImageCache.loadSlickImg("/spritesheet.png").getSubImage(64, 64, 64, 64)
}
