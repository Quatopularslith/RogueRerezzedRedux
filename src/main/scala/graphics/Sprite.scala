package graphics

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL11._
import org.lwjgl.util.vector.Vector4f

/**
 * Created by Razim on 7/8/2015.
 */
class Sprite(texId: Int, width: Float, height: Float, size: Int = 1000) {


  var x: Float = 0
  var y: Float = 0

  def setPos(x1: Float, y1: Float): Unit = {
    x = x1
    y = y1
  }


  def draw(): Unit = {
    glPushMatrix()
      glBindTexture(GL_TEXTURE_2D, texId)
      glBegin(GL_QUADS)
        glTexCoord2f(0,0)
        glVertex2f(x, y)

        glTexCoord2f(0,1)
        glVertex2f(x, y + height)

        glTexCoord2f(1,1)
        glVertex2f(x + width, y + height)

        glTexCoord2f(1,0)
        glVertex2f(x + width, y)
      glEnd()
    glPopMatrix()
  }

}
