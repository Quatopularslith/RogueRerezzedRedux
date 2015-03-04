package ui

/*
* Created by Mnenmenth
*/
import javax.swing.ImageIcon

import core.{ImageCache, Main}

import scala.Predef.{tuple2ToZippedOps => _}
import scala.swing._
import timeOut.{MButton, Buttons}

object MainScreen extends FlowPanel {
  var bHeight = (Main.height * .6).toInt
  var bWidth = (Main.width * .6).toInt
  val startGame = new Button {
    icon = new ImageIcon(ImageCache.loadImage("/button.png"))
    preferredSize = new Dimension(bHeight, bWidth)
  }
  val loadGame = new Button {
    icon = new ImageIcon(ImageCache.loadImage("/button.png"))
    preferredSize = new Dimension(bHeight, bWidth)
  }
  //MButton.addButton(Buttons.startGame)
  listenTo(startGame)
  listenTo(loadGame)
  focusable = true
  requestFocus()
}
