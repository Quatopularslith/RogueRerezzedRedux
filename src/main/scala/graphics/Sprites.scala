package graphics

/*
* Created by Mnenmenth
*/

import java.awt.geom.AffineTransform
import java.awt.image.{AffineTransformOp, BufferedImage}

import core.Implicits.SuperTuple
import org.newdawn.slick.{Animation, Image}

import scala.Predef.{tuple2ToZippedOps => _}

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