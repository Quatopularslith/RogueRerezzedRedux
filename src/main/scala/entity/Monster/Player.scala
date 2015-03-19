package entity.Monster

import java.awt.image.BufferedImage

import entity.Entity

/**
 * Created by torridon on 3/14/15.
 */
class Player(pos: (Int, Int)) extends Monster(pos, 100, 5, 5, 0) {
  override def getImage: BufferedImage = Entity.spriteSheet.get(0, 32, 16, 16)
}
