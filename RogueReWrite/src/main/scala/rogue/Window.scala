package rogue

import java.awt.Toolkit

import org.lwjgl.opengl.{DisplayMode, Display}

/**
 * Created by mnenmenth on 6/10/15.
 */
object Screen{
  def width = Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt
  def height = Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt
}


