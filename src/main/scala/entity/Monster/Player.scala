package entity.Monster

import entity.Entity
import graphics.ImageCache

/**
 * Created by torridon on 3/14/15.
 */
class Player(pos: (Int, Int)) extends Monster(pos, 100, 5, 5, 0) {
  override def getImage: Int = ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("spritesheet.png").getSubimage(0, 32, 16, 16))
  override def getImgWidth: Int = ImageCache.loadImage("spritesheet.png").getSubimage(0, 32, 16, 16).getWidth
  override def getImgHeight: Int = ImageCache.loadImage("spritesheet.png").getSubimage(0, 32, 16, 16).getHeight
}
