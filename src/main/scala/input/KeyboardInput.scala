package input

/*
* Created by Mnenmenth
*/

import core.Main
import graphics.{Player, GamePanel}
import org.newdawn.slick.{Input, GameContainer}
import ui.MainScreen

import scala.swing.event.{ButtonClicked, Key, KeyPressed}

object KeyboardInput {
  def slickPlayerMov(container: GameContainer, delta: Int): Unit = {
    //Get input from window
    val input: Input = container.getInput
    var mod: Float = 0.1f

    //Speed mod
    if(input.isKeyDown(Input.KEY_LSHIFT) || input.isKeyDown(Input.KEY_RSHIFT)){
      mod = 0.2f
      Player.duration = Array(50, 50)
    }

    //Up
    if (input.isKeyDown(Input.KEY_W)) {
      Player.sprite = Player.up
      Player.sprite.update(delta)
      Main.y -= delta * mod
      Main.offy -= (delta*mod).toInt
    }

    //Down
    if (input.isKeyDown(Input.KEY_S)) {
      Player.sprite = Player.down
      Player.sprite.update(delta)
      Main.y += delta * mod
      Main.offy += (delta*mod).toInt
    }

    //Left
    if (input.isKeyDown(Input.KEY_A)) {
      Player.sprite = Player.left
      Player.sprite.update(delta)
      Main.x -= delta * mod
      Main.offx -= (delta*mod).toInt
    }

    //Right
    if (input.isKeyDown(Input.KEY_D)) {
      Player.sprite = Player.right
      Player.sprite.update(delta)
      Main.x += delta * mod
      Main.offx += (delta*mod).toInt
    }
  }

  def keyReleased: Unit ={
    Player.sprite = Player.idle
    Player.duration = Array(300, 300)
  }
}