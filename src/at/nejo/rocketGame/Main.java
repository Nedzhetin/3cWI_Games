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
        boss = new Boss(580, -1500); // -500 bocause the Img is big
        rocket = new Rocket(800, 800);
        figures = new ArrayList<>();
        projectiles = new ArrayList<>();
        meteorites = new ArrayList<>();
        timer = new Timer();

        figures.add(rocket);


    }




    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        elapsedTime += delta; // so das der boss nicht derekt spwaned
        List<Figures> toRemove = new ArrayList<>();

        Meteorites.spawnMeteorit(delta,figures,meteorites);

        // Move all figures
        for (Figures figure : figures) {
            figure.move(delta, gameContainer);
        }



        //delete every objekt that goes of the screen
        // -1700 so the boss doesnt die when he is spawned
        figures.removeIf(projectile -> projectile.getY() < -1700 || projectile.getY() > gameContainer.getHeight());




        for (Projectiles projectile : projectiles) {
            if (isColliding(projectile, boss)) {
                if (boss.getY() >= 0) { // Ensure boss is on-screen
                    boss.setBosslifes(boss.getBosslifes() - 1);
                    System.out.println("It HITT");
                }
                toRemove.add(projectile);
            } else {
                for (Meteorites meteorite : meteorites) {
                    if (isColliding(meteorite, projectile)) {
                        meteorite.setMeteorLifes(meteorite.getMeteorLifes() - 1);
                        if (meteorite.getMeteorLifes() <= 0) {
                            toRemove.add(meteorite);
                        }
                        toRemove.add(projectile);
                        break; // Prevent duplicate checks
                    }
                }
            }
        }

        // Remove all collided object
        // I had to reacte the toRemove list because sometimes projectiles would go through the
        figures.removeAll(toRemove);
        projectiles.removeAll(toRemove);
        meteorites.removeAll(toRemove);

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
