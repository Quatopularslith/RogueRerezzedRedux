package entity.Monster

import core.ImageCache

/**
 * Created by torridon on 3/8/15.
 */

class Goblin(pos: (Double, Double)) extends Monster(pos, 10, 10, 10, 0) {
  //override def getImage: Int = ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64))
  override def getImage: Int = 2
  override def getImgWidth: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getWidth
  override def getImgHeight: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getHeight
}
