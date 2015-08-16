package graphics

import java.nio.FloatBuffer

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL15._
import org.lwjgl.opengl.GL11._

/**
 * Created by Razim on 8/16/2015.
 */
class StaticSprite(texId: Int, width: Float, height: Float, vertices: Int = 64, vertex_size: Int = 64, color_size: Int = 64) {

  var vboCreated = false
  var vertex_data: FloatBuffer = _
  var color_data: FloatBuffer = _

  val vbo_vertex_handle = glGenBuffers()
  val vbo_color_handle = glGenBuffers()

  def createVBO(): Unit ={
    println("Creating")
    vertex_data = BufferUtils.createFloatBuffer(vertices * vertex_size)
    vertex_data.put(Array(-1f, -1f, 0f))
    vertex_data.put(Array(1f, -1f, 0f))
    vertex_data.put(Array(1f, 1f, 0f))
    vertex_data.flip()

    color_data = BufferUtils.createFloatBuffer(vertices * color_size)
    color_data.put(Array(1f, 0f, 0f))
    color_data.put(Array(0f, 1f, 0f))
    color_data.put(Array(0f, 0f, 1f))
    color_data.flip()
    println("Created")
  }

  var x, y: Float = 0
  def setPos(x1: Float, y1: Float): Unit ={
    x = x1
    y = y1
  }

  def renderVBO(): Unit ={

    if(!vboCreated) {
      glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle)
      glBufferData(GL_ARRAY_BUFFER, color_data, GL_STATIC_DRAW)
      glBindBuffer(GL_ARRAY_BUFFER, 0)
      vboCreated = true
    }

    glPushMatrix()
      glBindTexture(GL_TEXTURE_2D, texId)
      glTranslatef(x, y, 0)
    glPopMatrix()

    glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle)
    glVertexPointer(vertex_size, GL_FLOAT, 0, 0l)

    glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle)
    glColorPointer(color_size, GL_FLOAT, 0, 0l)

    //glEnableClientState(GL_VERTEX_ARRAY)
    //glEnableClientState(GL_COLOR_ARRAY)

    glDrawArrays(GL_QUADS, 0, 1000)
    //glDisableClientState(GL_VERTEX_ARRAY)
    //glDisableClientState(GL_COLOR_ARRAY)

  }

  def deleteVBO(): Unit ={
    glDeleteBuffers(vbo_vertex_handle)
    glDeleteBuffers(vbo_color_handle)
  }

}
