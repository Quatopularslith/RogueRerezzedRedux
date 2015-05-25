package input

/*
* Created by Mnenmenth
*/

import graphics.DungeonRender
import org.lwjgl.input.Keyboard

object KeyboardInput {
  def mapCam: Unit ={
    val mod = 2
    if(Keyboard.isKeyDown(Keyboard.KEY_UP)) DungeonRender.offy += mod
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) DungeonRender.offy -= mod
    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) DungeonRender.offx -= mod
    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) DungeonRender.offx += mod
  }
}