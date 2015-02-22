package graphics
import javax.imageio.ImageIO

import scala.swing._

class LoadGraphics(image: String) extends Component {
  var img = ImageIO.read(getClass.getResourceAsStream(image))
  println("test1")
  if (img == null) {
    println(image + "not found")
  }
  val draw = new Panel {
    println("test2")
    override def paint(g: Graphics2D) {
      g.drawImage(img, img.getWidth(), img.getHeight(), null)
      println("test3")
    }
  }
}

