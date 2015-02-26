package ui

import graphics.Implicits.SuperTuple
import input.Button

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.ListBuffer
import scala.swing._


object MainScreen extends Panel {
  val buttons = ListBuffer.empty[Button]

  def addButton(b: Button) = buttons += b

  listenTo(mouse.clicks)
  focusable = true
  requestFocus

  override def paintComponent(g: Graphics2D) = {
    super.paintComponent(g)
    for (button <- buttons) g.drawImage(button.image, button.position.x, button.position.y, null)
  }
}
