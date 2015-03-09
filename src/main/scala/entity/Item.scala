package entity

import java.awt.image.BufferedImage

/**
 * Created by Torri on 3/1/2015.
 */
class Item extends Entity((0, 0), 10) {
  override def getImage: BufferedImage = null
}

object Item {
  def randItems(): Array[Item] = {
    null
  }
}
