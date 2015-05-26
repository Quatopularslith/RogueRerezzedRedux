package graphics

import core.{ImageCache, BuffImg}

/**
 * Created by Mnenmenth Alkaborin
 * https://github.com/Mnenmenth
 * Please do not re-distribute without permission
 */


object PlayerTest{
  def render(): Unit ={
    val buffImg = ImageCache.loadImage("spritesheet.png").getSubimage(0, 32, 16, 16)
    val sprite = ImageCache.loadTextureFromBuffImg(buffImg)
    val img = new BuffImg(sprite, buffImg.getWidth, buffImg.getHeight)
    //img.draw()
  }
}