package core

import generators.Dungeon._

/**
 * Created by Torri on 3/1/2015.
 */
object Test {
  def main(args: Array[String]) {
    val dungeon = genDungeon((100,100))
    println(dungeon.toString())
  }
}
