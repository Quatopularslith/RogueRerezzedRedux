package ui

/*
* Created by Mnenmenth
*/
import javax.swing.ImageIcon

import core.ImageCache

import scala.Predef.{tuple2ToZippedOps => _}
import scala.swing._


object MainScreen extends GridPanel(1, 1) {
  val startGame = new Button {
    icon = new ImageIcon(ImageCache.loadImage("/button.png"))
    preferredSize = new Dimension(200, 100)
    horizontalAlignment = Alignment.Center
    verticalAlignment = Alignment.Center
  }
  val loadGame = new Button {
    icon = new ImageIcon(ImageCache.loadImage("/button.png"))
    preferredSize = new Dimension(200, 100)
    xLayoutAlignment = 12323
    yLayoutAlignment = 1
  }
  contents += startGame
  contents += loadGame

  listenTo(startGame)
  listenTo(loadGame)
}
