package entity.Monster

import java.awt.image.BufferedImage

import entity.Entity
import org.newdawn.slick.Image

/**
 * Created by torridon on 3/14/15.
 */
class Player(pos: (Int, Int)) extends Monster(pos, 100, 5, 5, 0) {
  override def getImage: Image = Entity.spriteSheet.getSubImage(0, 32, 16, 16)
}
