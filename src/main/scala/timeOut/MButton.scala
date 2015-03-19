package timeOut

import java.awt.geom.AffineTransform
import java.awt.image.{AffineTransformOp, BufferedImage}

import core.Implicits.SuperTuple
import graphics.ImageCache

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.ListBuffer
import scala.swing._
import scala.swing.event.MouseClicked


object Buttons extends Component {
  val startGame = new GenericButton("/button.png", pos = (500, 500), action = StartGameButton)
}

object MButton extends Panel {
  val buttons = ListBuffer.empty[ButtonTrait]

  def addButton(b: ButtonTrait) = buttons += b

  listenTo(mouse.clicks)
  focusable = true
  requestFocus

  override def paintComponent(g: Graphics2D) = {
    super.paintComponent(g)
    for (button <- buttons) g.drawImage(button.image, button.position.x, button.position.y, null)
  }
}

trait ButtonTrait {
  protected var pos: (Int, Int)
  protected var scale: Double
  protected var action: Unit

  def position: (Int, Int) = pos

  def image: BufferedImage

  def rescale(sc: Double) = scale = sc

  def buttonAction(a: Unit) = action = a
}

class GenericButton(var imagePath: String, var pos: (Int, Int), var scale: Double = 1.0, var action: Unit) extends ButtonTrait {
  var image_ = image
  var bAction: Unit = buttonAction

  def image = image_

  def buttonAction = bAction

  override def rescale(sc: Double) = {
    super.rescale(sc)
    reload
  }

  private def reload = image_ = loadImage

  private def loadImage = {
    val image = ImageCache.loadImage(imagePath)
    val transform = new AffineTransformOp(AffineTransform.getScaleInstance(scale, scale), AffineTransformOp.TYPE_BICUBIC)
    val result = transform.createCompatibleDestImage(image, null)
    transform.filter(image, result)
  }
}

object ButtonInput {
  StartGameButton
}

object StartGameButton extends Panel {
  MButton.reactions += {
    case e: MouseClicked => {
      if (e.point.getX >= 500 && e.point.getX <= 600 && e.point.getY <= 500 && e.point.getY >= 400) {

      }
    }
  }
}
