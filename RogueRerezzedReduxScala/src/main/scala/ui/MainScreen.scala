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
   // icon =
  }
}

object MouseTest extends Panel {
  listenTo(mouse.clicks)
  MouseTest.reactions += {
    case e: MouseClicked => {
      println(e.point + "\n");
    }
  }
  focusable = true
  requestFocus
}