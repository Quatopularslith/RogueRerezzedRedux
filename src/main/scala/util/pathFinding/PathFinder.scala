package util.pathFinding

import generators.Dungeon
import util.MutableArray

/**
 * Baseline stuff for pathing
 * Created by Torri on 6/25/2015.
 */
abstract class PathFinder(dungeon: Dungeon) {
  def makePath(start: (Double, Double), end:(Double, Double), speed:Double, limit:Int):Path
}
class Path(val start:(Double, Double)) extends MutableArray[(Double,Double)]{
  this += start
}