package entity.Monster

import graphics.{BuffImg, Image, ImageCache}

/**
 * Created by torridon on 3/8/15.
 */

class Goblin(pos: (Int, Int)) extends Monster(pos, 10, 10, 10, 0) {
  override def getImage: Int = ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64))
  override def getImgWidth: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getWidth
  override def getImgHeight: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getHeight
}
