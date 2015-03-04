package core

import generators.Dungeon._

/**
 * Created by Torri on 3/1/2015.
 */
object Test {
  def main(args: Array[String]) {
    val dungeon = genDungeon()
    //val grouped = dungeon.groupBy(_._1._1)
    println(dungeon.toString())
  }
}
