package input

import graphics.GamePanel
import graphics.Sprites._

import scala.swing.event.{Key, KeyPressed}

object KeyboardInput {
  PotatoMov
  PlayerMov
}

object PotatoMov {
  GamePanel.reactions += {
    case KeyPressed(_, Key.Left, _, _) => potato.translate(-10, 0)
    case KeyPressed(_, Key.Right, _, _) => potato.translate(10, 0)
    case KeyPressed(_, Key.Up, _, _) => potato.translate(0, -10)
    case KeyPressed(_, Key.Down, _, _) => potato.translate(0, 10)
  }
}

object PlayerMov {
  GamePanel.reactions += {
    case KeyPressed(_, Key.A, _, _) => player.translate(-10, 0)
    case KeyPressed(_, Key.D, _, _) => player.translate(10, 0)
    case KeyPressed(_, Key.W, _, _) => player.translate(0, -10)
    case KeyPressed(_, Key.S, _, _) => player.translate(0, 10)
  }
}