package at.nejo.games.firstGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;

public class TestGame extends BasicGame {
    public TestGame(String name) {
        super(name);}

    @Override
    public void init(org.newdawn.slick.GameContainer gameContainer) throws org.newdawn.slick.SlickException {

    }

    @Override
    public void update(org.newdawn.slick.GameContainer gameContainer, int i) throws org.newdawn.slick.SlickException {

    }

    @Override
    public void render(org.newdawn.slick.GameContainer gameContainer, org.newdawn.slick.Graphics graphics) throws org.newdawn.slick.SlickException {

    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new TestGame("Test Game"));
            container.setDisplayMode(2000,1500,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
