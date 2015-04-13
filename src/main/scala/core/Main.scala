package core

/*
* Created by Mnenmenth
*/

import graphics.{Player, Sprites, GamePanel, ImageCache}
import input._
import org.newdawn.slick.{GameContainer, AppGameContainer, Image}
import timeOut.ButtonInput

object Main {
  val game = new AppGameContainer(new JMain("Hi"))
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
    //floor.draw(0, 0)
    Player.init
    KeyboardInput
  }

  def update(container: GameContainer, delta: Int): Unit = {
    //https://thejavablog.wordpress.com/2008/06/08/using-slick-2d-to-write-a-game/
    KeyboardInput
  }

  //GamePanel.addSprite(backgrnd)
  //GamePanel.addSprite(potato)
  //GamePanel.addSprite(player)

  //MButton.addButton(startGame)

  /*def top = new MainFrame {
    title = "RogueRerezzedRedux"
    preferredSize = new Dimension(width, height)
    contents = GamePanel
    centerOnScreen
  }*/

}