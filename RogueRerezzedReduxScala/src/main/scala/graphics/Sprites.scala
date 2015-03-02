package graphics

/*
* Created by Mnenmenth
*/

import java.awt.geom.AffineTransform
import java.awt.image.{AffineTransformOp, BufferedImage}

import core.ImageCache
import core.Implicits.SuperTuple

import scala.Predef.{tuple2ToZippedOps => _}

object Sprites {
  val backgrnd = new GenericSprite("/background.png", pos = (0, 0), scale = 2.71)
  val potato = new GenericSprite("/foot.png", pos = (100, 100), scale = 0.5)
  val player = new GenericSprite("/foot.png", pos = (200, 200), scale = 0.5)
}

trait Sprite {
  protected var pos: (Int, Int)
  protected var scale: Double

  def position: (Int, Int) = pos

  def image: BufferedImage

  def tick(i: Int) = {}

  def move(x: Int, y: Int) = pos = (x, y)

  def translate(dx: Int, dy: Int) = pos = (pos.x + dx, pos.y + dy)

  def rescale(sc: Double) = scale = sc
}
 class GenericSprite(imagePath: String, var pos: (Int, Int) = (0, 0), var scale: Double = 1.0) extends Sprite {
  var image_ = loadImage

  private def loadImage = {
    val img = ImageCache.loadImage(imagePath)
    val transform = new AffineTransformOp(AffineTransform.getScaleInstance(scale, scale), AffineTransformOp.TYPE_BICUBIC)
    val result = transform.createCompatibleDestImage(img, null)
    transform.filter(img, result)
  }

  private def reload = image_ = loadImage

  def image = image_

  override def rescale(sc: Double) = {
    super.rescale(sc)
    reload
  }
}