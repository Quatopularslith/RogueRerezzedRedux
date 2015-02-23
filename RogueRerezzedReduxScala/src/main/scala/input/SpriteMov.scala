package input

import graphics.GamePanel
import graphics.Sprites._

import scala.swing.event.{Key, KeyPressed}

object SpriteMov {
  val gamePanel = new GamePanel
  gamePanel.listenTo(gamePanel.keys)
  gamePanel.reactions += {
    case KeyPressed(_, Key.Left, _, _) => potato.translate(-10, 0)
    case KeyPressed(_, Key.Right, _, _) => potato.translate(10, 0)
    case KeyPressed(_, Key.Up, _, _) => potato.translate(0, -10)
    case KeyPressed(_, Key.Down, _, _) => potato.translate(0, 10)
  }
  gamePanel.focusable = true
  gamePanel.requestFocus
}
