package graphics

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import org.newdawn.slick.Image

import scala.collection.mutable

/**
 * Created by torridon on 3/12/15.
 */
class Spritesheet(path: String) {
  val img = ImageCache.loadImage(path)

  def get(x: Int, y: Int, sx: Int, sy: Int): BufferedImage = img.getSubimage(x, y, sx, sy)

  def getSquare(x: Int, y: Int, s: Int): BufferedImage = img.getSubimage(x, y, s, s)
}

object ImageCache {
  val imageCache = mutable.HashMap.empty[String, BufferedImage]
  val slickImgCache = mutable.HashMap.empty[String, Image]

  def loadImage(path: String) = {
    imageCache.getOrElseUpdate(path, ImageIO.read(getClass.getResourceAsStream(path)))
  }

  def loadSlickImg(path: String) = {
    slickImgCache.getOrElseUpdate(path, new Image(path))
  }
}