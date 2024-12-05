package at.nejo.rocketGame;

import org.newdawn.slick.*;

import java.util.*;

public class Main extends BasicGame {
    private List<Figures> figures;
    private List<Projectiles> rocketProjectiles;
    private List<Projectiles> bossProjectiles;
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
        rocketProjectiles = new ArrayList<>();
        bossProjectiles = new ArrayList<>();
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
        figures.removeIf(objekt -> objekt.getY() < -1700 || objekt.getY() > gameContainer.getHeight());




        for (Projectiles projectile : rocketProjectiles) {
            if (isColliding(projectile, boss)) {
                if (boss.getY() >= 0) { // Ensure boss is on-screen
                    boss.setBosslifes(boss.getBosslifes() - 1);
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

        for (Meteorites meteorite : meteorites) {
            if (isColliding(meteorite, rocket)) {
                System.out.println("hello");
            }
        }

        for (Projectiles bossProjectile : bossProjectiles) {
            if (isColliding(bossProjectile, rocket)) {
                System.out.println("it hit again");
            }
        }

        // Remove all collided object
        // I had to reacte the toRemove list because sometimes projectiles would go through the
        figures.removeAll(toRemove);
        rocketProjectiles.removeAll(toRemove);
        meteorites.removeAll(toRemove);

            // wait 2 seconds than if no more metorites than spawn boss

       if (elapsedTime >= bossDelay && meteorites.isEmpty() && !isBossSpawned) {
            figures.add(boss);
            isBossSpawned = true; // Prevent multiple spawns
        }

       if (boss.getY() >=20){
           boss.setX(boss.getX() + boss.getSpeedX()/delta);
           if (boss.getBosslifes() > 0 && boss.getY() >= 20 && elapsedTime >= 300) {
               elapsedTime = 0;
               Projectiles bossProjectile = new Projectiles(boss.getX() +320 ,boss.getY()+ 360,40,40,0,1,1);
               bossProjectiles.add(bossProjectile);
               figures.add(bossProjectile);
           }

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
            Projectiles projectile = new Projectiles(rocket.getX(), rocket.getY(), 20,20,0,-1,0);
            figures.add(projectile);
            rocketProjectiles.add(projectile);
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
