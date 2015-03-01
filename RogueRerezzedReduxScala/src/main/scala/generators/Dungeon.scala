package generators

import scala.collection.mutable.Map

/**
 * Created by Torri on 3/1/2015.
 */
object Dungeon {
  val ground = '#'
  val door = 'D'
  val secretDoor = 'S'
  val spawn = '$'
  val mobSpawn = 'M'
  val chest = 'C'

  def genDungeon(size: (Int, Int)):scala.collection.mutable.Map[(Int, Int), Char] = {
    var floor = scala.collection.mutable.Map[(Int, Int), Char]()
    def addRec(topLeft:(Int, Int), size:(Int, Int)): Unit ={
      for(xx <- topLeft._1 to (topLeft._1 + size._1)){
        for(yy <- topLeft._2 to (topLeft._2 + size._2)){

        }
      }
    }
    return null
  }
}