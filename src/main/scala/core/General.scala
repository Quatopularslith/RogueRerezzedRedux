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

  import scala.Predef.{tuple2ToZippedOps => _}

  implicit class SuperTuple[A, B](t: (A, B)) {
    def x = t._1

    def y = t._2

    def +(that: (A, B))(implicit numa: Numeric[A], numb: Numeric[B]) = {
      (numa.plus(t._1, that._1), numb.plus(t._2, that._2))
    }

    def -(that: (A, B))(implicit numa: Numeric[A], numb: Numeric[B]) = {
      (numa.minus(t._1, that._1), numb.minus(t._2, that._2))
    }
  }
}