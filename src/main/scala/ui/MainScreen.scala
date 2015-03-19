package ui

/*
* Created by Mnenmenth
*/

import javax.swing.ImageIcon

import core.Main
import graphics.ImageCache
import timeOut.{Buttons, MButton}

import scala.Predef.{tuple2ToZippedOps => _}
import scala.swing._

object MainScreen extends FlowPanel {
  val startGame = new Button {
    icon = new ImageIcon(ImageCache.loadImage("/button.png"))
    preferredSize = new Dimension(bHeight, bWidth)
  }
  val loadGame = new Button {
    icon = new ImageIcon(ImageCache.loadImage("/button.png"))
    preferredSize = new Dimension(bHeight, bWidth)
  }
  var bHeight = (Main.height * .6).toInt
  var bWidth = (Main.width * .6).toInt
  MButton.addButton(Buttons.startGame)
  contents += loadGame
  listenTo(startGame)
  listenTo(loadGame)
  focusable = true
  requestFocus()
}
