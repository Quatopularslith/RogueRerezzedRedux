package core

/*
* Created by Mnenmenth
*/

import java.awt.{Graphics2D, Rectangle}

import generators.{Dungeon, Tile}
import graphics.{Player, GamePanel, ImageCache}
import input._
import org.newdawn.slick.{GameContainer, AppGameContainer, Image}
import scala.Predef.{tuple2ToZippedOps => _}
import core.Implicits.SuperTuple

object Main {
  val game = new AppGameContainer(new JMain("RogueRerezzedRedux"))
  var x: Float = 34f
  var y: Float = 34f

  var offx = 0
  var offy = 0
  var tileSize = 64

  val xRange = Range.apply(offx / tileSize - 1, (Main.width + offx) / tileSize + 1)
  val yRange = Range.apply(-(offy / tileSize) - 1, (Main.height - offy) / tileSize + 1)

  val dungeon = Dungeon.genDungeon(100)
  var viewport = new Rectangle(0, 0, 1600, 900)

  def floor: Image = ImageCache.loadSlickImg("foot.png")

  def main(): Unit = {
    game.setDisplayMode(width, height, false)
    game.setShowFPS(true)
    game.start()
  }

  /*def height = GamePanel.peer.getHeight match {
    case 0 => 500
    case n => n
  }

  def width = GamePanel.peer.getWidth match {
    case 0 => 750
    case n => n
  }*/

  def height = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt
  def width = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def init(): Unit = {
  }

  def render(): Unit = {
    //Player.sprite.draw(x.toInt, y.toInt)

  }

  def update(container: GameContainer, delta: Int): Unit = {
    //https://thejavablog.wordpress.com/2008/06/08/using-slick-2d-to-write-a-game/
    //KeyboardInput.slickPlayerMov(container, delta)
    dungeon.floor.filterKeys(p => xRange.contains(p.x) && yRange.contains(p.y)).foreach(t => {
      GamePanel.addToQueue(Tile.Floor.img, (t._1.x * tileSize - offx, t._1.y * tileSize + offy))
      GamePanel.addToQueue(t._2.img, (t._1.x * tileSize - offx, t._1.y * tileSize + offy))
    })
    GamePanel.repaint()
  }

}