package graphics

/*
* Created by Mnenmenth
*/

import java.awt.{Dimension, Rectangle}
import java.util.{Timer, TimerTask}

import core.Implicits.SuperTuple

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.ListBuffer
import scala.swing._

object GamePanel extends Panel {
  val sprites = ListBuffer.empty[Sprite]
  def addSprite(s: Sprite) = sprites += s
  var viewport = new Rectangle(0, 0, 1600, 900)

  preferredSize = new Dimension(viewport.width, viewport.height)

  listenTo(keys)
  focusable = true
  requestFocus

  var currentTick = 0
  val timer = new Timer
  timer.scheduleAtFixedRate(new TimerTask {
    override def run() = {
      sprites.foreach(_.tick(currentTick))
      currentTick += 1
    }
  }, 0, 10)
  timer.scheduleAtFixedRate(new TimerTask {
    override def run() = repaint
  }, 0, 17)

  override def paintComponent(g: Graphics2D) = {
    super.paintComponent(g)
    g.translate(viewport.x, viewport.y)
    for (sprite <- sprites) g.drawImage(sprite.image, sprite.position.x, sprite.position.y, null)
  }
}