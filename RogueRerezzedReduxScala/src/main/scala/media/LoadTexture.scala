package media

import java.awt.image._
import java.awt._
import java.awt.event._
import java.io._
import javax.imageio._
import javax.swing._

object LoadTexture extends Component {
  var img: BufferedImage = null

  def draw(g: Graphics) {
    g.drawImage(img, 0, 0, null)
  }

  def loadTex(texture: String) = ImageIO.read(new File(texture))

  def getImgSize: Dimension = {
    if (img == null) {
      return new Dimension(100, 100)
    } else {
      return new Dimension(img.getWidth(null), img.getHeight(null))
    }
  }
}