package at.nejo.snowWorld;

import at.nejo.games.firstGame.ObjektGame;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class SnowWorld extends BasicGame {
    private List<Shape> shapes;




    public SnowWorld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        shapes = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Snowflake bigSnow = new Snowflake(Snowflake.SIZE.BIG);
            shapes.add(bigSnow);
        }
        for (int i = 0; i < 50; i++) {
            Snowflake mediumSnow = new Snowflake(Snowflake.SIZE.MEDIUM);
            shapes.add(mediumSnow);
        }
        for (int i = 0; i < 50; i++) {
            Snowflake smallSnow = new Snowflake(Snowflake.SIZE.SMALL);
            shapes.add(smallSnow);
        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Shape shape : shapes) {
            shape.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Shape shape : shapes) {
            shape.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new SnowWorld("first Game"));
            container.setDisplayMode(2000,1500,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
