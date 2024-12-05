package at.nejo.rocketGame;

import org.newdawn.slick.*;

import java.util.List;
import java.util.Random;

public class Meteorites implements Figures{
    private float x,y;
    private int hight, width;
    Image meteoritImg;
    private int meteorLifes;
    private AngelCodeFont font = new AngelCodeFont("testdata/hiero.fnt","testdata/hiero.png");
    public enum Size{BIG,MEDIUM,SMALL}


    private static int elapsedTime = 0;
    private static int meteoriteInterval = 1000; // 1000 ms (1 second)
    private static int meteoriteCount = 0;


    public Meteorites() throws SlickException {
    }

    public Meteorites(Size size) throws SlickException {

        Image tmp = new Image("testdata/meteoritImg.png");
        Random random = new Random();
        int randomX = random.nextInt(1400);

        if (size == Size.BIG) {
            this.x = randomX;
            this.y = -100;
            this.hight = 200;
            this.width = 200;
            this.meteorLifes = 5;
            this. meteoritImg = tmp.getScaledCopy(this.width,this.hight);
        }else if (size == Size.MEDIUM) {
            this.x = randomX;
            this.y = -100;
            this.hight = 150;
            this.width = 150;
            this.meteorLifes = 3;
            this.meteoritImg = tmp.getScaledCopy(this.width,this.hight);
        }else if (size == Size.SMALL) {
            this.x = randomX;
            this.y = -100;
            this.hight = 100;
            this.width = 100;
            this.meteorLifes = 1;
            this.meteoritImg = tmp.getScaledCopy(this.width,this.hight);
        }



    }


    @Override
    public void draw(Graphics graphics) {
        meteoritImg.draw(this.x, this.y);
        font.drawString(this.x + this.width /2 -10,this.y +this.hight/2 - 25,"" +this.meteorLifes );
    }

    @Override
    public void move(float delta, GameContainer container) {
        this.y += 0.3;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getHeight() {
        return this.hight;
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    public int getMeteorLifes(){
        return this.meteorLifes;
    }

    public void setMeteorLifes(int meteorLifes) {
        this.meteorLifes = meteorLifes;
    }


    public static void spawnMeteorit(int delta, List<Figures> figures, List<Meteorites> meteorites) throws SlickException {
        elapsedTime += delta;

        // Create meteorites at intervals
        if (elapsedTime >= meteoriteInterval && meteoriteCount < 2) {
            Random random = new Random();
            int randomSize = random.nextInt(3);
            Meteorites meteorite = null;
           switch (randomSize) {
               case 0:
                    meteorite = new Meteorites(Size.BIG);
                    break;
               case 1:
                    meteorite = new Meteorites(Size.MEDIUM);
                    break;
               case 2:
                   meteorite = new Meteorites(Size.SMALL);
                   break;
           }
           
            figures.add(meteorite);
            meteorites.add(meteorite);
            meteoriteCount++;
            elapsedTime = 0; // Reset the timer
        }
    }

}
