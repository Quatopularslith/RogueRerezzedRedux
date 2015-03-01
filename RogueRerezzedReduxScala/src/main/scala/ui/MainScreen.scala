package ui

import javax.swing.ImageIcon

import graphics.ImageCache

import scala.Predef.{tuple2ToZippedOps => _}
import scala.swing._


object MainScreen extends Panel {
  val button = new Button {
    icon = new ImageIcon(ImageCache.loadImage("/foot.png"))
  }
  contents = new BoxPanel(Orientation.Vertical) {

  }
}
