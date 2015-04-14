package graphics

/*
* Created by Mnenmenth
*/

import java.awt.geom.AffineTransform
import java.awt.image.{AffineTransformOp, BufferedImage}

import core.Implicits.SuperTuple
import org.newdawn.slick.{Animation, Image}

import scala.Predef.{tuple2ToZippedOps => _}

object Sprites {
  val backgrnd = new GenericSprite("/background.png", pos = (0, 0), scale = 2.71)
  val potato = new GenericSprite("/spritesheet.png", pos = (100, 100), scale = 0.5)
  val player = new GenericSprite("/spritesheet.png", pos = (200, 200), scale = 0.5)
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

  def image = image_

  override def rescale(sc: Double) = {
    super.rescale(sc)
    reload
  }

  private def reload = image_ = loadImage

  private def loadImage = {
    val img = ImageCache.loadImage(imagePath)
    val transform = new AffineTransformOp(AffineTransform.getScaleInstance(scale, scale), AffineTransformOp.TYPE_BICUBIC)
    val result = transform.createCompatibleDestImage(img, null)
    transform.filter(img, result)
  }
}


object Player{
  val movementIdle: Array[Image] = Array(new Image("spritesheet.png").getSubImage(0, 1, 64, 64), new Image("spritesheet.png").getSubImage(0, 20, 64, 64))
  val movementUp: Array[Image] = Array(new Image("spritesheet.png").getSubImage(192, 0, 64, 64), new Image("spritesheet.png").getSubImage(212, 0, 64, 64))
  val movementDown: Array[Image] = Array(new Image("spritesheet.png").getSubImage(0, 128, 64, 64), new Image("spritesheet.png").getSubImage(0, 148, 64, 64))
  val movementLeft: Array[Image] = Array(new Image("spritesheet.png").getSubImage(201, 124, 64, 64), new Image("spritesheet.png").getSubImage(101, 224, 64, 64))
  val movementRight: Array[Image] = Array(new Image("spritesheet.png").getSubImage(201, 124, 64, 64), new Image("spritesheet.png").getSubImage(101, 224, 64, 64))
  val movementUpLeft: Array[Image] = Array(new Image("spritesheet.png").getSubImage(201, 124, 64, 64), new Image("spritesheet.png").getSubImage(101, 224, 64, 64))
  val movementUpRight: Array[Image] = Array(new Image("spritesheet.png").getSubImage(201, 124, 64, 64), new Image("spritesheet.png").getSubImage(101, 224, 64, 64))
  val movementDownLeft: Array[Image] = Array(new Image("spritesheet.png").getSubImage(201, 124, 64, 64), new Image("spritesheet.png").getSubImage(101, 224, 64, 64))
  val movementDownRight: Array[Image] = Array(new Image("spritesheet.png").getSubImage(201, 124, 64, 64), new Image("spritesheet.png").getSubImage(101, 224, 64, 64))
  var duration: Array[Int] = Array(300, 300)

  val idle= new Animation(movementIdle, duration, true)
  val up = new Animation(movementUp, duration, false)
  val down = new Animation(movementDown, duration, false)
  val left = new Animation(movementLeft, duration, false)
  val right = new Animation(movementRight, duration, false)
  val upLeft = new Animation(movementUpLeft, duration, false)
  val upRight = new Animation(movementUpRight, duration, false)
  val downLeft = new Animation(movementDownLeft, duration, false)
  val downRight = new Animation(movementDownRight, duration, false)

  var sprite = idle
}