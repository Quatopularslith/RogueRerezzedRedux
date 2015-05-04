package core;

import generators.Dungeon;
import graphics.GamePanel;
import input.KeyboardInput;
import org.newdawn.slick.*;
import java.awt.Font;

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
    public static Font font = new Font("Verdana", Font.BOLD, 40);
    public static TrueTypeFont ttf;

    public static void main(String args[]) throws SlickException {
        game = new AppGameContainer(new JMain("Rogue Rerezzed Redux"));
        game.setDisplayMode(Main.width(), Main.height(), false);
        game.setShowFPS(true);
        game.start();
    }

    public void init(GameContainer arg0) throws SlickException {
        ttf = new TrueTypeFont(font, false);
        Main.init();
    }

    public void render(GameContainer arg0, Graphics arg1) throws SlickException {
        Main.render();
        if(!Dungeon.percentComplete().equals("99")){
            ttf.drawString(game.getScreenWidth()/4, game.getScreenHeight()/4, "Loading... " + Dungeon.percentComplete() + "%", Color.red);
        }

    }

    public void update(GameContainer arg0, int arg1) throws SlickException {
        Main.update(arg0, arg1);
    }

    public void keyReleased(int key, char c){
        KeyboardInput.keyReleased();
    }
}
