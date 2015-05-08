package core

/*
* Created by Mnenmenth
*/

import generators.Dungeon
import graphics.{GamePanel, ImageCache, Player}
import input._
import org.newdawn.slick.GameContainer

import scala.Predef.{tuple2ToZippedOps => _}

object Main {

  def SCREEN_HEIGHT = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getHeight.toInt * .75).toInt

  def SCREEN_WIDTH = (java.awt.Toolkit.getDefaultToolkit.getScreenSize.getWidth.toInt * .75).toInt

  def WINDOW_HEIGHT = JMain.game.getScreenHeight

  def WINDOW_WIDTH = JMain.game.getScreenWidth

  def CENTER_HEIGHT = WINDOW_HEIGHT/4

  def CENTER_WIDTH = WINDOW_WIDTH/4

  var x = CENTER_WIDTH
  var y = CENTER_HEIGHT

  var no = false
  var mov = true

  def init(){
    sprite
  }

  def sprite = ImageCache.loadSlickImg("spritesheet.png")

  def render(): Unit = {
    GamePanel.render()
    Player.sprite.draw(x, y)
  }

  def update(container: GameContainer, delta: Int): Unit = {
    System.out.println((x,y))
    System.out.println(x)
        GamePanel.floorQueue()

    //Attempting to compare this to player's position. However, x and y are only relative to the drawing on the screen.
    //Now that I think of it, this would be the same problem with the setSpawn thing. Offx and Offy would need to be set first
    //to set the screen over the right area, then the player position would need to be set to place them on the correct spawn pos
    GamePanel.edges.foreach(e => if(e._1 != (x,y) || e._2 != (x,y)){
      mov = true
    }else{
      mov = false
    })

    if(mov) KeyboardInput.mapUpdate(container, delta)


    if (Dungeon.percentComplete.equals("100") && !no) {
      try {
        KeyboardInput.lockCam = false
        val spawn = Player.spawnPoint
        x = spawn._1
        y = spawn._2
        GamePanel.setFocus(spawn)
        System.out.println(spawn._1 + ", " + spawn._2)
        no = true
      }catch{
        case e: IndexOutOfBoundsException=> System.out.println("I'M NOT DONE YET")
      }
    }
  }

}