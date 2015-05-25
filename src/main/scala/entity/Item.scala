package entity

/**
 * Created by Torri on 3/1/2015.
 */
class Item extends Entity((0, 0), 10) {
  override def getImage: Int = 0
  override def getImgWidth: Int = 0
  override def getImgHeight: Int = 0
}

object Item {
  def randItems(): Array[Item] = {
    null
  }
}
