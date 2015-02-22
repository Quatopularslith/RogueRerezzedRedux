package core

import javax.swing.{ImageIcon, JFrame, JLabel}
import javax.imageio.ImageIO

object Main {
  def main(args: Array[String]) {
    val window = new JFrame("RogueRerezzedRedux")
    window.setVisible(true)
    window.setSize(1280, 720)
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    window.add(new JLabel(new ImageIcon(ImageIO.read(getClass.getResourceAsStream("/foot.png")))))
    window.revalidate()
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