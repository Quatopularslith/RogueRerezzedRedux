package core

import java.io.File
import javax.imageio.ImageIO
import javax.swing.JFrame
import media._
class loadTex(texture: String){
  LoadTexture.img = ImageIO.read(new File(texture))
}
object Main {
  def main(args: Array[String]) {
    val window = new JFrame("RogueRerezzedRedux")
    window.setVisible(true)
    window.setSize(1280, 720)
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    window.add(LoadTexture.loadTex("foot.png"))
  }
}