package input

import graphics.GamePanel
import graphics.Sprites._
import ui.MainScreen

import scala.swing.event.{ButtonClicked, Key, KeyPressed}

object KeyboardInput {
  potatoMov
  playerMov
  startGameButton
  loadGameButton

  def potatoMov {
    GamePanel.reactions += {
      case KeyPressed(_, Key.Left, _, _) => potato.translate(-10, 0)
      case KeyPressed(_, Key.Right, _, _) => potato.translate(10, 0)
      case KeyPressed(_, Key.Up, _, _) => potato.translate(0, -10)
      case KeyPressed(_, Key.Down, _, _) => potato.translate(0, 10)
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