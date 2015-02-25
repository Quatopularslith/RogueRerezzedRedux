package ui

import javax.swing.ImageIcon

import scala.swing._
import scala.swing.event.MouseClicked


object MainScreen extends Panel {
  val titleLabel = new Label {
    text = "RogueRerezzedRedux"
  }
  val bs = new ImageIcon("")
  val button = new Button {
    icon =
  }
}

object MouseTest extends Panel {
  listenTo(MouseTest.mouse.clicks)
  MouseTest.reactions += {
    case MouseClicked(MouseTest, _, _, _, _) => println("asdgd")
  }
  focusable = true
  requestFocus
}