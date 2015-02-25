package core

import graphics.GamePanel
import graphics.Sprites._
import input._
import ui._


import scala.swing._

object Main extends SimpleSwingApplication {
  GamePanel.addSprite(backgrnd)
  GamePanel.addSprite(potato)
  GamePanel.addSprite(player)
  MouseTest
  KeyboardInput

  def top = new MainFrame {
    title = "RogueRerezzedRedux"
    preferredSize = new Dimension(1600, 900)
    contents = GamePanel
    centerOnScreen

  }

}