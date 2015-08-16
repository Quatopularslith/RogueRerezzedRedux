package entity.Monster

import generators.Dungeon
import graphics.ImageCache
import input.KeyboardInput

/**
 * Created by torridon on 3/14/15.
 */
class Player(inipos: (Double, Double), dungeon: Dungeon) extends Monster(inipos, 100, 5, 5, 0, dungeon) {
  override def getId: Int = 7

  override def getImgWidth: Int = ImageCache.loadImage("spritesheet.png").getSubimage(0, 32, 16, 16).getWidth

  override def getImgHeight: Int = ImageCache.loadImage("spritesheet.png").getSubimage(0, 32, 16, 16).getHeight

  override def doTurn: Unit = {
    val dpos = KeyboardInput.playerMove
    def npos = (pos._1 + dpos._1, pos._2 + dpos._2)
    if (dungeon.floor.contains((npos._1.toInt, npos._2.toInt))) {
      setPos(npos)
    }
  }
}