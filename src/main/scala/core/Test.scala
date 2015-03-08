package core

import generators.Dungeon._

import scala.util.Random

/**
 * Created by Torri on 3/1/2015.
 */
object Test {
  def main(args: Array[String]) {
    for (x <- 1 to 5) {
      val roomCount = Random.nextInt(100) + 150
      val dungeon = genDungeon(roomCount)
      println(dungeon.toString)
    }
    //val grouped = dungeon.groupBy(_._1._1)
    //println(dungeon.toString())
    //dungeon.groupBy(_._1._2).values.foreach(row => println(row.toList.sortBy(_._1._1).mkString(", ")))
  }
}
