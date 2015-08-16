package entity.Monster

import generators.Dungeon
import graphics.ImageCache
import util.pathFinding.{DepthFirst, Path, Random}

/**
 * Created by torridon on 3/8/15.
 */

class Goblin(inipos: (Double, Double), dungeon: Dungeon) extends Monster(inipos, 10, 10, 10, 0, dungeon) {
  //override def getImage: Int = ImageCache.loadTextureFromBuffImg(ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64))
  override def getId: Int = 8

  override def getImgWidth: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getWidth

  override def getImgHeight: Int = ImageCache.loadImage("spritesheet.png").getSubimage(64, 64, 64, 64).getHeight

  val speed = /*1.0/64.0*/ 0.0
  var turns = -2
  val pathFinder = new DepthFirst(dungeon)
  val wanderer = new Random
  var path: Path = null

  override def doTurn: Unit = {
    turns += 1
    if (turns == -1) {
      val there = dungeon.entities(0).pos
      if ((there._1 - pos._1) * (there._1 - pos._1) + (there._2 - pos._2) * (there._2 - pos._2) <= 5) {
        path = wanderer.makePath(pos, (0, 0), speed, 20)
      } else {
        path = pathFinder.makePath(pos, there, speed, 20)
      }
      turns += 1
      setPos(path.toArray(turns))
    }
    if (turns >= 0 && turns < path.length) {
      setPos(path.toArray(turns))
    }
    if (turns == path.length) {
      turns = -2
    }
  }
}
