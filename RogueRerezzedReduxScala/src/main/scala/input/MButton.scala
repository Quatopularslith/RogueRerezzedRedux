package input

import java.awt.geom.AffineTransform
import java.awt.image.{AffineTransformOp, BufferedImage}

import graphics.ImageCache
import ui.MainScreen

import scala.Predef.{tuple2ToZippedOps => _}
import scala.swing._
import scala.swing.event.MouseClicked


object Buttons {
  val startGame = new GenericButton("/button.png", pos = (500, 500), action = StartGameButton)
}

trait Button {
  protected var pos: (Int, Int)
  protected var scale: Double

  def position: (Int, Int) = pos

  def image: BufferedImage

  def rescale(sc: Double) = scale = sc
}

class GenericButton(var imagePath: String, var pos: (Int, Int), var scale: Double = 1.0, var action: Unit) extends Button {
  var image_ = image

  private def loadImage = {
    val image = ImageCache.loadImage(imagePath)
    val transform = new AffineTransformOp(AffineTransform.getScaleInstance(scale, scale), AffineTransformOp.TYPE_BICUBIC)
    val result = transform.createCompatibleDestImage(image, null)
    transform.filter(image, result)
  }

  private def reload = image_ = loadImage

  def image = image_

  override def rescale(sc: Double) = {
    super.rescale(sc)
    reload
  }
}

object ButtonInput {
  StartGameButton
}

object StartGameButton extends Panel {
  MainScreen.reactions += {
    case e: MouseClicked => {
      if (e.point.getX >= 500 && e.point.getX <= 600 && e.point.getY <= 500 && e.point.getY >= 400) {

      }
    }
  }
}
