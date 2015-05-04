package core

/*
* Created by Mnenmenth
*/

import graphics.{GamePanel, ImageCache, Player}
import input._
import org.newdawn.slick.GameContainer

import scala.Predef.{tuple2ToZippedOps => _}

object Main {
  var x: Float = 34f
  var y: Float = 34f

  def height = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt

  def width = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def init(){
    sprite
  }

  def sprite = ImageCache.loadSlickImg("spritesheet.png")

  def render(): Unit = {
    GamePanel.render()
    Player.sprite.draw(JMain.game.getScreenWidth/4, JMain.game.getScreenHeight/4)
  }

  def update(container: GameContainer, delta: Int): Unit = {
        GamePanel.floorQueue()
        KeyboardInput.mapUpdate(container, delta)
  }

}