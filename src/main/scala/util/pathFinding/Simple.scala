package util.pathFinding

import generators.Dungeon
import util.Vector

/**
 * He went that way!
 * Oof! And I would have gotten away with it too, if it weren't for those meddling walls
 * Created by Torri on 6/25/2015.
 */
class Simple(dungeon: Dungeon) extends PathFinder(dungeon) {
  override def makePath(start: (Double, Double), end: (Double, Double), speed: Double, limit: Int): Path = {
    val path = new Path(start)
    var x = start._1
    var y = start._2
    for (a <- 1 to limit) {
      val distVec = new Vector(end._1 - x, end._2 - y).getUnit * speed
      x += distVec.x
      y += distVec.y
      path +=(x, y)
      if ((x - end._1) * (x - end._1) + (y - end._2) * (y - end._2) <= 1) return path
    }
    path
  }

  def pathExists(pos: (Double, Double), end: (Double, Double), dungeon: Dungeon): Boolean = {
    if (math.abs(pos._1 - end._1) > Dungeon.maxSize * 2 || math.abs(pos._2 - end._2) > Dungeon.maxSize * 2) return false
    val sameX = end._1 == pos._1
    val slope = {
      if (sameX) {
        (end._1 - pos._1) / (end._2 - pos._2)
      } else {
        (end._2 - pos._2) / (end._1 - pos._1)
      }
    }
    def f(x: Int) = {
      if (sameX) {
        slope * (x - pos._2) + pos._1 // x = f(y)
      } else {
        slope * (x - pos._1) + pos._2 // y = f(x)
      }
    }
    val x = {
      if (sameX) {
        pos._2
      } else {
        pos._1
      }
    }
    val xx = {
      if (sameX) {
        end._2
      } else {
        end._1
      }
    }
    val from: Int = {
      if (x > xx) {
        xx.toInt
      } else {
        x.toInt
      }
    }
    val to: Int = {
      if (x > xx) {
        x.toInt
      } else {
        xx.toInt
      }
    }
    for (x <- from to to) {
      val xRange = {
        if (sameX) {
          (f(x) - 1).toInt to (f(x) + 1).toInt
        } else {
          x - 1 to x + 1
        }
      }
      val yRange = {
        if (sameX) {
          x - 1 to x + 1
        } else {
          (f(x) - 1).toInt to (f(x) + 1).toInt
        }
      }
      if (!dungeon.floor.keys.exists(t => xRange.contains(t._1) && yRange.contains(t._2))) {
        return false
      }
    }
    true
  }
}
