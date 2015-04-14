package core

/*
* Created by Mnenmenth
*/

import graphics.{Player, Sprites, GamePanel, ImageCache}
import input._
import org.newdawn.slick.{GameContainer, AppGameContainer, Image}
import timeOut.ButtonInput

object Main {
  val game = new AppGameContainer(new JMain("RogueRerezzedRedux"))
  var x: Float = 34f
  var y: Float = 34f
  def floor: Image = ImageCache.loadSlickImg("foot.png")

  def main(): Unit = {
    game.setDisplayMode(width, height, false)
    game.setShowFPS(true)
    game.start()
  }

  def height = GamePanel.peer.getHeight match {
    case 0 => 500
    case n => n
  }

  def width = GamePanel.peer.getWidth match {
    case 0 => 750
    case n => n
  }

  def init(): Unit = {
    floor
  }

  def render(): Unit = {
    Player.sprite.draw(x.toInt, y.toInt)
  }

  def update(container: GameContainer, delta: Int): Unit = {
    //https://thejavablog.wordpress.com/2008/06/08/using-slick-2d-to-write-a-game/
    KeyboardInput.slickPlayerMov(container, delta)
  }

}