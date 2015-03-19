package graphics

/*
* Created by Mnenmenth
*/

import java.awt.{Color, Dimension, Rectangle}
import java.util.{Timer, TimerTask}

import core.Implicits.SuperTuple
import core.Main
import generators.{Dungeon, Tile}

import scala.Predef.{tuple2ToZippedOps => _}
import scala.collection.mutable.ListBuffer
import scala.swing._

object GamePanel extends Panel {
  val sprites = ListBuffer.empty[Sprite]
  val timer = new Timer
  val dungeon = Dungeon.genDungeon(100)
  var viewport = new Rectangle(0, 0, 1600, 900)

  preferredSize = new Dimension(viewport.width, viewport.height)

  listenTo(keys)
  focusable = true
  requestFocus
  var currentTick = 0
  var offx = 0
  timer.scheduleAtFixedRate(new TimerTask {
    override def run() = {
      sprites.foreach(_.tick(currentTick))
      currentTick += 1
    }
  }, 0, 10)
  timer.scheduleAtFixedRate(new TimerTask {
    override def run() = repaint
  }, 0, 17)
  var offy = 0
  var tileSize = 64

  def addSprite(s: Sprite) = sprites += s

  override def paintComponent(g: Graphics2D) = {
    super.paintComponent(g)
    g.setColor(Color.BLACK)
    g.fillRect(0, 0, peer.getWidth, peer.getHeight)
    val xRange = Range.apply(offx / tileSize - 1, (Main.width + offx) / tileSize + 1)
    val yRange = Range.apply(-(offy / tileSize) - 1, (Main.height - offy) / tileSize + 1)
    dungeon.floor.filterKeys(p => xRange.contains(p.x) && yRange.contains(p.y)).foreach(t => {
      g.drawImage(Tile.Floor.img, t._1.x * tileSize - offx, t._1.y * tileSize + offy, null)
      g.drawImage(t._2.img, t._1.x * tileSize - offx, t._1.y * tileSize + offy, null)
    })
    g.translate(viewport.x, viewport.y)
    for (sprite <- sprites) g.drawImage(sprite.image, sprite.position.x, sprite.position.y, null)
  }
}