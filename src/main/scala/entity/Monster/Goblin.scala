package entity.Monster

import core.ImageCache
import generators.Dungeon
import util.pathFinding.DepthFirst

/**
 * Created by torridon on 3/8/15.
 */

class Goblin(pos: (Double, Double), dungeon: Dungeon) extends Monster(pos, 10, 10, 10, 0, dungeon) {
  //override def getImage: Int = ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64))
  override def getImage: Int = 2
  override def getImgWidth: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getWidth
  override def getImgHeight: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getHeight

  var turns = 0
  val pathFinder = new DepthFirst(dungeon)
  override def doTurn: Unit = {

  }
}
