package graphics
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import swing._

class loadGraphics(image:String) extends Component{
  var bufferedImage:BufferedImage = null
  def draw(g:Graphics2D){
    bufferedImage = ImageIO.read(getClass.getResourceAsStream(image))
    g.drawImage(bufferedImage, 0, 0, null)
  }
}

