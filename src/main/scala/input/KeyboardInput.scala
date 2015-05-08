package input

/*
* Created by Mnenmenth
*/

import core.Main
import graphics.{GamePanel, Player}
import org.newdawn.slick.{GameContainer, Input}

object KeyboardInput {
  var lockCam = true
  def mapUpdate(container: GameContainer, delta: Int): Unit = {
    //Get input from window
    val input: Input = container.getInput

    playerCam
    mapCam

    def playerCam: Unit = {
      var mod: Float = 0.2f
      //Speed mod
      if (input.isKeyDown(Input.KEY_LSHIFT) || input.isKeyDown(Input.KEY_RSHIFT)) {
        mod = 0.3f
        Player.duration = Array(50, 50)
      }

      //Up
      if (input.isKeyDown(Input.KEY_W)) {
        Player.sprite = Player.up
        Player.sprite.update(delta)
        Main.y -= (delta * mod).toInt
      }

      //Down
      if (input.isKeyDown(Input.KEY_S)) {
        Player.sprite = Player.down
        Player.sprite.update(delta)
        Main.y += (delta * mod).toInt
      }

      //Left
      if (input.isKeyDown(Input.KEY_A)) {
        Player.sprite = Player.left
        Player.sprite.update(delta)
        Main.x -= (delta * mod).toInt
      }

      //Right
      if (input.isKeyDown(Input.KEY_D)) {
        Player.sprite = Player.right
        Player.sprite.update(delta)
        Main.x += (delta * mod).toInt
      }
    }

    def mapCam: Unit = {
      var mod: Float = 0.1f
      //Speed mod
      if (input.isKeyDown(Input.KEY_LSHIFT) || input.isKeyDown(Input.KEY_RSHIFT)) {
        mod = 0.4f
      }
      val movement = (delta * mod * 2).toInt

      //Lock Cam to Player
      if(input.isKeyPressed(Input.KEY_L)) lockCam = !lockCam
      if(lockCam){
        locked
      }else{
        unlocked
      }


      //Reset Cam to Player



      def locked: Unit ={
        mod = 0.2f
        if (input.isKeyDown(Input.KEY_LSHIFT) || input.isKeyDown(Input.KEY_RSHIFT)) {
          mod = 0.3f
        }

        //Up
        if (input.isKeyDown(Input.KEY_W)) {
          GamePanel.offy += (delta * mod).toInt
        }

        //Down
        if (input.isKeyDown(Input.KEY_S)) {
          GamePanel.offy -= (delta * mod).toInt
        }

        //Left
        if (input.isKeyDown(Input.KEY_A)) {
          GamePanel.offx -= (delta * mod).toInt
        }

        //Right
        if (input.isKeyDown(Input.KEY_D)) {
          GamePanel.offx += (delta * mod).toInt
        }
      }

      def unlocked: Unit ={
        //Up
        if (input.isKeyDown(Input.KEY_UP)) {
          GamePanel.offy += movement
          Main.y += movement
        }

        //Down
        if (input.isKeyDown(Input.KEY_DOWN)) {
          GamePanel.offy -= movement
          Main.y -= movement
        }

        //Left
        if (input.isKeyDown(Input.KEY_LEFT)) {
          GamePanel.offx -= movement
          Main.x += movement
        }

        //Right
        if (input.isKeyDown(Input.KEY_RIGHT)) {
          GamePanel.offx += movement
          Main.x -= movement
        }
      }
    }
  }

  def keyReleased: Unit = {
    Player.sprite = Player.idle
    Player.duration = Array(300, 300)
  }

}