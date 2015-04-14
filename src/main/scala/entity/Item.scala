package entity

import java.awt.image.BufferedImage

import org.newdawn.slick.Image

/**
 * Created by Torri on 3/1/2015.
 */
class Item extends Entity((0, 0), 10) {
  override def getImage: Image = null
}

object Item {
  def randItems(): Array[Item] = {
    null
  }
}
