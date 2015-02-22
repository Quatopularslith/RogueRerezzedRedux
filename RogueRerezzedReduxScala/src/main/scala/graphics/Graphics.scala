package graphics

import java.awt.Image
import javax.imageio.ImageIO

import graphics.Implicits.SuperTuple

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.swing._

object ImageCache {
  val imageCache = mutable.HashMap.empty[String, Image]

  def loadImage(path: String) = {
    imageCache.getOrElseUpdate(path, ImageIO.read(getClass.getResourceAsStream(path)))
  }
}

class GamePanel extends Panel {
  val sprites = ListBuffer.empty[Sprite]

  override def paint(g: Graphics2D) = for (sprite <- sprites) g.drawImage(sprite.image, sprite.position.x, sprite.position.y, null)
}

trait Sprite {
  def position: (Int, Int)

  def image: Image
}

class StaticSprite(pos: (Int, Int), imagePath: String) extends Sprite {
  def position = pos

  def image = ImageCache.loadImage(imagePath)
}

object Implicits {

  implicit class SuperTuple[A, B](t: (A, B)) {
    def x = t._1

    def y = t._2
  }

}