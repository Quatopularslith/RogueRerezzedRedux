package core

/*
* Created by Mnenmenth
*/

import java.awt.{Dimension, Toolkit}

import graphics.GamePanel
import input._
import timeOut.ButtonInput

import scala.swing._

object Main extends SimpleSwingApplication {

  def height = GamePanel.peer.getHeight match {
    case 0 => 500
    case n => n
  }

  def width = GamePanel.peer.getWidth match {
    case 0 => 750
    case n => n
  }

  //GamePanel.addSprite(backgrnd)
  //GamePanel.addSprite(potato)
  //GamePanel.addSprite(player)

  //MButton.addButton(startGame)

  KeyboardInput
  ButtonInput

  def top = new MainFrame {
    title = "RogueRerezzedRedux"
    preferredSize = new Dimension(width, height)
    contents = GamePanel
    centerOnScreen
  }

}