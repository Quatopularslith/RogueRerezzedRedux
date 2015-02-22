package core

import graphics.loadGraphics

import scala.swing._
object Main {
  def main(args: Array[String]) {
    Window.top
  }
}

object Window extends SimpleSwingApplication{

  def top = new MainFrame {
    title = "RogueRerezzedRedux"
    preferredSize = new Dimension(1024, 700)
    //contents = new Button {
    //  action = Action("Click") {
    //    println("hi")
    //  }
    //}
    contents = new loadGraphics("/foot.png")
    centerOnScreen
  }
}

//**//
//"Scala z is sorcery. I don't like it but I'm sure torri will" - Aaron
//"Its supposedly useful but in my opinion I have no idea what it is" - Aaron
//torri l00k
//**  val floor: Map[(Int, Int), Tile]
//get tile at 5,6
//**  floor((5,6))
//iz given region of tiles empty
//**  floor.filterKeys(c => c._1 >= 5 && c._1 <= 10 && c._2 >= 3 && c._2 <= 8)
//return is empty (can a room be put there
//**  floor.filterKeys(c => c._1 >= 5 && c._1 <= 10 && c._2 >= 3 && c._2 <= 7).values.forall(isGround)
//**//
//**//
//Random Aaron stuff
//**  object Foo { def apply(...) = ... }
//**    Foo.apply(...) == Foo(...)