package at.nejo.rocketGame;

import at.nejo.games.firstGame.ObjektGame;
import org.newdawn.slick.*;

import java.util.*;

public class Main extends BasicGame {
    private List<Figures> figures;
    private List<Projectiles> projectiles;
    private List<Meteorites> meteorites;
    private Rocket rocket;
    private Image tmp;
    private Image backgroundImg;
    Timer timer;
    private AngelCodeFont font;
    private Boss boss;
    private boolean isBossSpawned = false;

    private int bossDelay = 2000; // 2 seconds delay
    private int elapsedTime = 0;



    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        tmp = new Image("testdata/spaceImg.jpg");
        backgroundImg = tmp.getScaledCopy(2000, 1500);
        rocket = new Rocket(800, 700);
        figures = new ArrayList<>();
        projectiles = new ArrayList<>();
        meteorites = new ArrayList<>();
        timer = new Timer();
        font = new AngelCodeFont("testdata/hiero.fnt","testdata/hiero.png");
        boss = new Boss(580, -500); // -200 bocause the Img is big



        figures.add(rocket);
    }




    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        elapsedTime += delta; // so das der boss nicht derekt spwaned

        Meteorites.spawnMeteorit(delta,figures,meteorites);

        // Move all figures
        for (Figures figure : figures) {
            figure.move(delta, gameContainer);
        }


        //delete every objekt that goes of the screen
        figures.removeIf(projectile -> projectile.getY() < -200 || projectile.getY() > gameContainer.getHeight());


        for (int i = 0; i < meteorites.size(); i++) {
            Meteorites meteorite = meteorites.get(i);
            for (int j = 0; j < projectiles.size(); j++) {
                Projectiles projectile = projectiles.get(j);

                // Check collision
                if (isColliding(meteorite, projectile)) {
                    // Remove collided objects
                    meteorite.setMeteorLifes(meteorite.getMeteorLifes() - 1);
                    if (meteorite.getMeteorLifes() == 0) {
                        figures.remove(meteorite);
                        meteorites.remove(i);
                    }
                    figures.remove(projectile);
                    projectiles.remove(j);

                    // Adjust indices
                    i--;
                    j--;
                    break; // Exit inner loop after removing projectile
                }
            }
        }

            // wait 2 seconds than if no more metorites than spawn boss
        if (elapsedTime >= bossDelay && meteorites.isEmpty() && !isBossSpawned) {
            figures.add(boss);
            isBossSpawned = true; // Prevent multiple spawns
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        backgroundImg.draw();

        // Draw all figures
        for (Figures figure : figures) {
            figure.draw(graphics);
        }

        for(Meteorites meteorite : meteorites){
            graphics.setLineWidth(12);

            font.drawString(meteorite.getX() +meteorite.getWidth()/2 -10,meteorite.getY() +meteorite.getHeight()/2 - 25,"" + meteorite.getMeteorLifes());
        }
    }


    @Override
    public void keyPressed(int key, char c) {
        // Shoot a projectile when SPACE is pressed
        if (key == Input.KEY_SPACE) {
            Projectiles projectile = new Projectiles(rocket.getX(), rocket.getY(), 20,20);
            figures.add(projectile);
            projectiles.add(projectile);
        }
    }

    // Collision detection helper method
    private boolean isColliding(Figures a, Figures b) {

        return a.getX() < b.getX() + b.getWidth() &&
                a.getX() + a.getWidth() > b.getX() &&
                a.getY() < b.getY() + b.getHeight() &&
                a.getY() + a.getHeight() > b.getY();
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Rocket game"));
            container.setDisplayMode(2000, 1500, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
