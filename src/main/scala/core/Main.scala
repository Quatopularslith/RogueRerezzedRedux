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

  def SCREEN_HEIGHT = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt

  def SCREEN_WIDTH = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def WINDOW_HEIGHT = JMain.game.getScreenHeight

  def WINDOW_WIDTH = JMain.game.getScreenWidth

  def CENTER_HEIGHT = WINDOW_HEIGHT/4

  def CENTER_WIDTH = WINDOW_WIDTH/4

  def init(){
    sprite
  }

  def sprite = ImageCache.loadSlickImg("spritesheet.png")

  def render(): Unit = {
    GamePanel.render()
    Player.sprite.draw(CENTER_WIDTH, CENTER_HEIGHT)
  }

  def update(container: GameContainer, delta: Int): Unit = {
        GamePanel.floorQueue()
        KeyboardInput.mapUpdate(container, delta)
  }

}