package input

/*
* Created by Mnenmenth
*/

import graphics.RenderDungeon
import org.lwjgl.input.Keyboard

object KeyboardInput {
  def mapCam: Unit ={
    var mod = 2
    if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) mod = 10
    if(Keyboard.isKeyDown(Keyboard.KEY_UP)) RenderDungeon.offy += mod
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) RenderDungeon.offy -= mod
    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) RenderDungeon.offx -= mod
    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) RenderDungeon.offx += mod
  }
  def playerMove: (Double, Double) ={
    val speed = 5.0/64.0
    var y = 0.0
    var x = 0.0
    if(Keyboard.isKeyDown(Keyboard.KEY_W)) y -= speed
    if(Keyboard.isKeyDown(Keyboard.KEY_S)) y += speed
    if(Keyboard.isKeyDown(Keyboard.KEY_A)) x -= speed
    if(Keyboard.isKeyDown(Keyboard.KEY_D)) x += speed
    (x,y)
  }
}