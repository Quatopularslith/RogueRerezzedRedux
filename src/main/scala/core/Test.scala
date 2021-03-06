package core

import generators.Dungeon
import generators.Dungeon._

import scala.collection.JavaConversions

/**
 * This is MY class. Get out
 * Created by Torri on 3/1/2015.
 * No - Earl
 */
object Test {
  implicit def string2Iterable(s: String) = JavaConversions.asJavaIterable(List(s))

  def main(args: Array[String]) {
    println("Starting Generation")
    val roomCount = Dungeon.rand.nextInt(10) + 10
    val dungeon = genDungeonNoThread(roomCount)
    println(dungeon.toString)
    //Files.write(Paths.get(s"dungeon1.txt"), dungeon.toString)
    println("DONE")


    /* println("Lets PathFind!")
     var i:Int = 0
     dungeon.entities.toArray.foreach(t=> {
       i += 1
       val path = new DepthFirst(dungeon).makePath(t.pos, (dungeon.getSpawn._1.toDouble, dungeon.getSpawn._2.toDouble), 0.5, 1000)
       println("The Path is " + path.length + " moves long")
       val pathString = {
         var temp = "x\ty"
         path.toArray.foreach(t=> temp += "\r\n" + t._1 + "\t" + t._2)
         temp
       }
       Files.write(Paths.get(s"path$i.txt"), pathString)
     })*/
  }
}
