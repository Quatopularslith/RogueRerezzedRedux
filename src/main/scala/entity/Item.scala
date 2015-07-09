package entity

/**
 * Created by Torri on 3/1/2015.
 */
class Item extends Entity((0, 0), 10, null) {
  override def getId: Int = 0
  override def getImgWidth: Int = 0
  override def getImgHeight: Int = 0
  override def doTurn: Unit = null
}

object Item {
  def randItems(): Array[Item] = {
    null
  }
}
