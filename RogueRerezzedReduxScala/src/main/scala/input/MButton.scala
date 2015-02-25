package input

import java.awt.geom.AffineTransform
import java.awt.image.{AffineTransformOp, BufferedImage}

import graphics.ImageCache

import scala.swing.Panel


object MButton extends Panel {

}

trait Button {
  protected var pos: (Int, Int)
  protected var scale: Double

  def position = (Int, Int) = pos

  def image: BufferedImage

  def rescale(sc: Double) = scale = sc
}

class GenericButton(var pos: (Int, Int), var img: String, var scale: Double = 1.0, var action: Unit) extends Button {
  var image_ = image

  private def loadImage = {
    val image = ImageCache.loadImage(img)
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
