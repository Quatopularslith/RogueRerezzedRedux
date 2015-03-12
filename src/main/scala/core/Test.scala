package core

import java.nio.file.{Files, Paths}

import generators.Dungeon
import generators.Dungeon._

import scala.collection.JavaConversions

/**
 * Created by Torri on 3/1/2015.
 */
object Test {
  implicit def string2Iterable(s: String) = JavaConversions.asJavaIterable(List(s))

  def main(args: Array[String]) {
    println("Starting Generation")
    //for (x <- 1 to 5) {150
      val roomCount = Dungeon.rand.nextInt(100) + 150
      val dungeon = genDungeon(roomCount)
    //println(dungeon.toString)
    Files.write(Paths.get(s"dungeon1.txt"), dungeon.toString)
    //}
    println("DONE")
  }
}
