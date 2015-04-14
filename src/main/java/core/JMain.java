package core;

import input.KeyboardInput;
import org.newdawn.slick.*;

/**
 * Created by Mnenmenth Alkaborin
 * https://github.com/Mnenmenth
 * Please do not re-distribute without permission
 */

//Each method will take method from Main.scala
// It should not require any editing

public class JMain extends BasicGame {

    public static AppGameContainer game;
    public JMain(String title) {
        super(title);
    }

    public static void main(String args[]) throws SlickException {
        game = new AppGameContainer(new JMain("RogueRerezzedRedux"));
        game.setDisplayMode(Main.width(), Main.height(), false);
        game.setShowFPS(true);
        game.start();
    }

    public void init(GameContainer arg0) throws SlickException {
        Main.init();
    }

    public void render(GameContainer arg0, Graphics arg1) throws SlickException {
        Main.render();
    }

    public void update(GameContainer arg0, int arg1) throws SlickException {
        Main.update(arg0, arg1);
    }

    public void keyReleased(int key, char c){
        KeyboardInput.keyReleased();
    }
}
