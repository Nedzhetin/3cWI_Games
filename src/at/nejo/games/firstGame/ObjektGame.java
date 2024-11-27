package at.nejo.games.firstGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjektGame extends BasicGame {

    public int containerWidth;
    private int containerHight;

    private List<Shape> shapes;


    public ObjektGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.containerWidth = gameContainer.getWidth();
        this.containerHight = gameContainer.getHeight();

        this.shapes = new ArrayList<Shape>();
        Random random = new Random();


        for (int i = 0; i < 5; i++) {
            int random600X = random.nextInt(600);
            int random600Y = random.nextInt(600);
            double random10Y = random.nextDouble();
            double random10X = random.nextDouble();


            Circle circle = new Circle(random600X,random600Y,50,random10X,random10Y);
            Rectangle rectangle = new Rectangle(random600X,random600Y,50,50,random10X,random10Y);
            shapes.add(rectangle);
            shapes.add(circle);
        }

        Rocket rocket = new Rocket(100,100);
        shapes.add(rocket);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Shape shape : shapes) {
            shape.update(delta, gameContainer);
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
            AppGameContainer container = new AppGameContainer(new ObjektGame("first Game"));
            container.setDisplayMode(2000,1500,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public int getContainerWidth() {
        return containerWidth;
    }

    public int getContainerHeight() {
        return containerHight;
    }
}
