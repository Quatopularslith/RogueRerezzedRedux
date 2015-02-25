package core

import java.awt.{Toolkit, Dimension}

import graphics.GamePanel
import graphics.Sprites._
import input._
import ui._


import scala.swing._

object Main extends SimpleSwingApplication {
  var screenSize = Toolkit.getDefaultToolkit().getScreenSize()
  var height: Double = screenSize.getHeight / .25
  var height1: Int = height.toInt
  var width: Double = screenSize.getWidth / .25
  var width1: Int = width.toInt
  GamePanel.addSprite(backgrnd)
  GamePanel.addSprite(potato)
  GamePanel.addSprite(player)
  MouseTest
  KeyboardInput

  def top = new MainFrame {
    title = "RogueRerezzedRedux"
    preferredSize = new Dimension(width1, height1)
    contents = MouseTest
    centerOnScreen

  }

}