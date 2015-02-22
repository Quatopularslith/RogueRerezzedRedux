package core

import javax.swing.JFrame
object Main {
  def main(args: Array[String]) {
    val window = new JFrame("RogueRerezzedRedux")
    window.setVisible(true)
    window.setSize(1280, 720)
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  }
}
