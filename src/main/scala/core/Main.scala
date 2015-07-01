package core

/*
* Created by Mnenmenth
*/

import java.awt.Font

import generators.Dungeon
import generators.Dungeon._
import graphics.RenderDungeon
import input.KeyboardInput
import org.lwjgl.LWJGLException
import org.lwjgl.opengl.GL11._
import org.lwjgl.opengl.{Display, DisplayMode}
import org.newdawn.slick.TrueTypeFont
import org.newdawn.slick.opengl.TextureImpl

import scala.Predef.{tuple2ToZippedOps => _}

object Main {

  def SCREEN_HEIGHT = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt

  def SCREEN_WIDTH = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def WINDOW_HEIGHT = Display.getHeight

  def WINDOW_WIDTH = Display.getWidth

  def CENTER_HEIGHT = WINDOW_HEIGHT / 4

  def CENTER_WIDTH = WINDOW_WIDTH / 4

  var font: TrueTypeFont = null
  def main(args: Array[String]): Unit = {

    glInit
    Dungeon.genDungeon(10)

    while(!Display.isCloseRequested) {
      if(dungeon != null) {
        renderGame
        updateGame
      }else{
        glClear(GL_COLOR_BUFFER_BIT)
        TextureImpl.bindNone()
        font.drawString(CENTER_WIDTH, CENTER_HEIGHT, Dungeon.percentComplete)
      }

      Display.update()
      Display.sync(60)
    }

    Display.destroy()
    System.exit(1)

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
    glShadeModel(GL_SMOOTH)
    glDisable(GL_DEPTH_TEST)
    glDisable(GL_LIGHTING)
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
    glClearColor(0f, 0f, 0f, 0f)
    glClearDepth(1)
    font =  new TrueTypeFont(new Font("Arial", Font.PLAIN, 28), true)
  }

  def renderGame: Unit ={
    glClear(GL_COLOR_BUFFER_BIT)
    RenderDungeon.render()
  }

  def updateGame: Unit = {
    KeyboardInput.mapCam
    RenderDungeon.floorQueue()

    if(dungeon.entities.nonEmpty){
      dungeon.entities.foreach(t=> t.doTurn)
      RenderDungeon.entityQueue()
    }
  }

  def println(thing: Any): Unit ={
    System.out.println(thing)
  }

}