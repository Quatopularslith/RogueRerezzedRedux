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
  var height: Double = screenSize.getHeight * .75
  var height1: Int = height.toInt
  var width: Double = screenSize.getWidth * .75
  var width1: Int = width.toInt
  println(height1)
  println(width1)
  GamePanel.addSprite(backgrnd)
  GamePanel.addSprite(potato)
  GamePanel.addSprite(player)

  MButton.addButton(startGame)

  KeyboardInput
  ButtonInput

  def top = new MainFrame {
    title = "RogueRerezzedRedux"
    preferredSize = new Dimension(width1, height1)
    contents = MainScreen
    centerOnScreen

  }

}