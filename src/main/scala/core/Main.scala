package core

/*
* Created by Mnenmenth
*/

import graphics.RenderDungeon
import input.KeyboardInput
import org.lwjgl.LWJGLException
import org.lwjgl.opengl.GL11._
import org.lwjgl.opengl.{Display, DisplayMode}

import scala.Predef.{tuple2ToZippedOps => _}

object Main {

  def SCREEN_HEIGHT = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt

  def SCREEN_WIDTH = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def WINDOW_HEIGHT = Display.getHeight

  def WINDOW_WIDTH = Display.getWidth

  def CENTER_HEIGHT = WINDOW_HEIGHT / 4

  def CENTER_WIDTH = WINDOW_WIDTH / 4

  def main(args: Array[String]): Unit = {

    glInit

    while (!Display.isCloseRequested) {
      render
      update

      Display.update()
      Display.sync(60)
    }

    Display.destroy()

  }

  def glInit: Unit = {

    Display.setTitle("Rogue Rerezzed Redux")
    try {
      Display.setDisplayMode(new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT))
      Display.setVSyncEnabled(true)
      Display.create()
    } catch {
      case e: LWJGLException => System.out.println(e.printStackTrace())
        System.out.println("Shit happened m8")
    }

    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, WINDOW_WIDTH, WINDOW_HEIGHT, 0, 1, -1)
    glMatrixMode(GL_MODELVIEW)
    glEnable(GL_TEXTURE_2D)
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
    glClearColor(0f, 0f, 0f, 0f)
  }

  def render: Unit ={
    glClear(GL_COLOR_BUFFER_BIT)
    RenderDungeon.render()
  }

  def update: Unit ={
    KeyboardInput.mapCam
    RenderDungeon.floorQueue()
  }
}