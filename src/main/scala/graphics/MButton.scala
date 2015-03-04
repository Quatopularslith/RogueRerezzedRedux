package graphics

import java.awt.image.BufferedImage

import scala.swing.Component

/**
 * Created by Razim
 */

class MButton(var imagePath: String, var pos: (Int, Int), var action: Unit) extends ButtonTrait{
  var image_ = image
}

trait ButtonTrait{
  protected var pos: (Int, Int)
  protected var action: Unit

  def position: (Int, Int) = pos
  def image: BufferedImage
  def buttonAction: Unit = action
}