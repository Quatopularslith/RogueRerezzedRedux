package graphics

import org.lwjgl.BufferUtils
import org.lwjgl.util.vector.Vector4f
import org.lwjgl.opengl.GL11._

/**
 * Created by Razim on 7/8/2015.
 */
class Sprite(texId: Int, width: Float, height: Float, size: Int = 1000) {

  val emptyRegion: Array[Float] = Array(0, 0, 1, 0, 1, 1, 0, 1)
  val emptyCol = new Vector4f(0,0,0,0)

  val vertArray = new Array[Float](size*2*4)
  val vertBuff = BufferUtils.createFloatBuffer(vertArray.length)
  val colorArray = new Array[Byte](size*4*4)
  val colBuff = BufferUtils.createByteBuffer(colorArray.length)
  val texArray = new Array[Float](size*2*4)
  val texBuff = BufferUtils.createFloatBuffer(texArray.length)

  var vertIndex = 0
  var colIndex = 0
  var texIndex = 0
  val maxDraws = size
  var draws = 0

  var currentTex: Int = 0
  var texid = texId

  def getColor(f: Float): Byte = (f*255).toByte

  def render(): Unit = {
    //println("rendering")

    glBindTexture(GL_TEXTURE_2D, texId)
    vertBuff.put(vertArray)
    vertBuff.flip()

    colBuff.put(colorArray)
    colBuff.flip()

    texBuff.put(texArray)
    texBuff.flip()

    glVertexPointer(2, 0, vertBuff)
    glColorPointer(4, true, 0, colBuff)
    glTexCoordPointer(2, 0, texBuff)
    glDrawArrays(GL_QUADS, 0, draws * 4)

    vertBuff.clear()
    colBuff.clear()
    texBuff.clear()
    vertIndex = 0
    colIndex = 0
    texIndex = 0
    draws = 0
  }

  var x: Float = 0
  var y: Float = 0

  def setPos(x1: Float, y1: Float): Unit ={
    if(texId != 9000) {
      x = x1
      y = y1
    }
  }


  def draw(rotation: Float = 0, region: Array[Float] = emptyRegion, col: Vector4f = emptyCol): Unit ={
    //println("Draw")
    if(texId != 9000) {
      //if (texId != currentTex) {
       //println("Texid != currenttex")
        render()
        currentTex = texId
      //}
      //println("texid != 9000")
      if (draws == maxDraws) render()

      val p1x: Float = -width / 2
      val p1y: Float = -height / 2
      val p2x: Float = width / 2
      val p2y: Float = -height / 2
      val p3x: Float = width / 2
      val p3y: Float = height / 2
      val p4x: Float = -width / 2
      val p4y: Float = height / 2

      var x1: Float = 0
      var y1: Float = 0
      var x2: Float = 0
      var y2: Float = 0
      var x3: Float = 0
      var y3: Float = 0
      var x4: Float = 0
      var y4: Float = 0

      if (rotation != 0) {
        val cos = math.cos(rotation * math.Pi / 180).toFloat
        val sin = math.sin(rotation * math.Pi / 180).toFloat

        x1 = cos * p1x - sin * p1y
        y1 = sin * p1x + cos * p1y

        x2 = cos * p2x - sin * p2y
        y2 = sin * p2x + cos * p2y

        x3 = cos * p3x - sin * p3y
        y3 = sin * p3x + cos * p3y

        x4 = cos * p4x - sin * p4y
        y4 = sin * p4x + cos * p4y
      } else {
        x1 = p1x
        y1 = p1y

        x2 = p2x
        y2 = p2y

        x3 = p3x
        y3 = p3y

        x4 = p4x
        y4 = p4y
      }

      x1 += x
      x2 += x
      x3 += x
      x4 += x
      y1 += y
      y2 += y
      y3 += y
      y4 += y

      vertArray(vertIndex) = x1
      texArray(texIndex) = region(0)
      vertArray(vertIndex + 1) = y1
      texArray(texIndex + 1) = region(1)

      vertArray(vertIndex + 2) = x2
      texArray(texIndex + 2) = region(2)
      vertArray(vertIndex + 3) = y2
      texArray(texIndex + 3) = region(3)

      vertArray(vertIndex + 4) = x3
      texArray(texIndex + 4) = region(4)
      vertArray(vertIndex + 5) = y3
      texArray(texIndex + 5) = region(5)

      vertArray(vertIndex + 6) = x4
      texArray(texIndex + 6) = region(6)
      vertArray(vertIndex + 7) = y4
      texArray(texIndex + 7) = region(7)

      colorArray(colIndex) = getColor(col.x)
      colorArray(colIndex + 1) = getColor(col.y)
      colorArray(colIndex + 2) = getColor(col.z)
      colorArray(colIndex + 3) = getColor(col.w)

      colorArray(colIndex + 4) = getColor(col.x)
      colorArray(colIndex + 5) = getColor(col.y)
      colorArray(colIndex + 6) = getColor(col.z)
      colorArray(colIndex + 7) = getColor(col.w)

      colorArray(colIndex + 8) = getColor(col.x)
      colorArray(colIndex + 9) = getColor(col.y)
      colorArray(colIndex + 10) = getColor(col.z)
      colorArray(colIndex + 11) = getColor(col.w)

      colorArray(colIndex + 12) = getColor(col.x)
      colorArray(colIndex + 13) = getColor(col.y)
      colorArray(colIndex + 14) = getColor(col.z)
      colorArray(colIndex + 15) = getColor(col.w)

      vertIndex += 8
      texIndex += 8
      colIndex += 16
      draws += 1
    }
  }

}
