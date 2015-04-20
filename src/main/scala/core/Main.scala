package core

/*
* Created by Mnenmenth
*/

import java.awt.Font

import generators.Dungeon
import graphics.{GamePanel, ImageCache}
import input._
import org.newdawn.slick.{Color, TrueTypeFont, GameContainer}
import scala.Predef.{tuple2ToZippedOps => _}

object Main {
  var x: Float = 34f
  var y: Float = 34f

  def sprite = ImageCache.loadSlickImg("spritesheet.png")

  def height = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt
  def width = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def init(){
    sprite
  }

  def render(): Unit = {
    if(GamePanel.dungeon != null){
      GamePanel.render()
    }
  }

  def update(container: GameContainer, delta: Int): Unit = {
    GamePanel.floorQueue()
    KeyboardInput.slickPlayerMov(container, delta)
  }

}