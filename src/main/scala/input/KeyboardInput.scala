package input

/*
* Created by Mnenmenth
*/

import core.Main
import graphics.{Player, GamePanel}
import graphics.Sprites._
import org.newdawn.slick.{Input, GameContainer}
import ui.MainScreen

import scala.swing.event.{ButtonClicked, Key, KeyPressed}

object KeyboardInput {
  moveScreen
  playerMov
  startGameButton
  loadGameButton

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

    }

    //Down
    if (input.isKeyDown(Input.KEY_S)) {
      Player.sprite = Player.down
      Player.sprite.update(delta)
      Main.y += delta * mod

    }

    //Left
    if (input.isKeyDown(Input.KEY_A)) {
      Player.sprite = Player.left
      Player.sprite.update(delta)
      Main.x -= delta * mod

    }

    //Right
    if (input.isKeyDown(Input.KEY_D)) {
      Player.sprite = Player.right
      Player.sprite.update(delta)
      Main.x += delta * mod

    }
  }

  def keyReleased: Unit ={
    Player.sprite = Player.idle
    Player.duration = Array(300, 300)
  }

  def moveScreen {
    GamePanel.reactions += {
      case KeyPressed(_, Key.Left, _, _) => GamePanel.offx -= 64
      case KeyPressed(_, Key.Right, _, _) => GamePanel.offx += 64
      case KeyPressed(_, Key.Up, _, _) => GamePanel.offy += 64
      case KeyPressed(_, Key.Down, _, _) => GamePanel.offy -= 64
    }
  }

  def playerMov {
    GamePanel.reactions += {
      case KeyPressed(_, Key.A, _, _) => player.translate(-10, 0)
      case KeyPressed(_, Key.D, _, _) => player.translate(10, 0)
      case KeyPressed(_, Key.W, _, _) => player.translate(0, -10)
      case KeyPressed(_, Key.S, _, _) => player.translate(0, 10)
    }
  }

  def startGameButton {
    MainScreen.startGame.reactions += {
      case ButtonClicked(b) => println("Ha! That tickles!")
    }
  }

  def loadGameButton {
    MainScreen.loadGame.reactions += {
      case ButtonClicked(b) => println("Ha! That really tickles!")
    }
  }
}