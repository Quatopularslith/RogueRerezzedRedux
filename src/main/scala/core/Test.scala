package core

import generators.Dungeon
import generators.Dungeon._

import scala.collection.JavaConversions

/**
 * Created by Torri on 3/1/2015.
 */
object Test {
  implicit def string2Iterable(s: String) = JavaConversions.asJavaIterable(List(s))

  def main(args: Array[String]) {
    for (x <- 1 to 5) {
      val roomCount = Dungeon.rand.nextInt(100) + 150
      val dungeon = genDungeon(roomCount)
      println(dungeon.toString)
      //Files.write(Paths.get(s"dungeon$x.txt"), dungeon.toString)
    }
    println("DONE")
  }
}
