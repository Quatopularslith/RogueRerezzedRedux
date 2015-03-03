package core

/*
* Created by Mnenmenth
*/

import java.awt.{Dimension, Toolkit}

import graphics.GamePanel
import graphics.Sprites._
import input._
import timeOut.Buttons._
import timeOut.{ButtonInput, MButton}
import ui._

import scala.swing._

object Main extends SimpleSwingApplication {
  var screenSize = Toolkit.getDefaultToolkit().getScreenSize()
  var height = (screenSize.getHeight * .75).toInt
  var width = (screenSize.getWidth * .75).toInt
  println(height)
  println(width)
  GamePanel.addSprite(backgrnd)
  GamePanel.addSprite(potato)
  GamePanel.addSprite(player)

  MButton.addButton(startGame)

  KeyboardInput
  ButtonInput

  def top = new MainFrame {
    title = "RogueRerezzedRedux"
    preferredSize = new Dimension(width, height)
    contents = MainScreen
    centerOnScreen

  }

}