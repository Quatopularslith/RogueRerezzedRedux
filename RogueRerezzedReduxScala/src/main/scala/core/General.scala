package core

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable

/**
 * Created by Mnenmenth
 */


object ImageCache {
  val imageCache = mutable.HashMap.empty[String, BufferedImage]

  def loadImage(path: String) = {
    imageCache.getOrElseUpdate(path, ImageIO.read(getClass.getResourceAsStream(path)))
  }
}

object Implicits {

  implicit class SuperTuple[A, B](t: (A, B)) {
    def x = t._1

    def y = t._2
  }

}