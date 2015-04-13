package core

/*
* Created by Mnenmenth
*/

import graphics.{GamePanel, ImageCache}
import input._
import org.newdawn.slick.Image
import timeOut.ButtonInput

object Main {
  val game = JMain.game
  var floor: Image = ImageCache.loadSlickImg("null")

  def main(): Unit = {
    game.setDisplayMode(height, width, false)
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
    floor = ImageCache.loadSlickImg("foot.png")
  }

  def render(): Unit = {
    floor.draw(0, 0)
  }

  def update(): Unit = {
    KeyboardInput
    ButtonInput
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