package at.nejo.snowWorld;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Snowflake implements Shape {
    private int x;
    private int y;
    private int speed;
    private int radius;
    private double speedY;
    public enum SIZE {BIG,MEDIUM,SMALL}

    Random random = new Random();
    int randomX = random.nextInt(2000);
    int randomY = random.nextInt(1200) -1200;


   public Snowflake(SIZE size) {
        if (size == SIZE.BIG) {
            this.x = randomX;
            this.y = randomY;
            this.speedY = 2;
            this.radius = 30;
        }else if (size == SIZE.MEDIUM) {
            this.x = randomX;
            this.y = randomY;
            this.speedY = 1.5;
            this.radius = 20;
        }else if (size == SIZE.SMALL) {
            this.x = randomX;
            this.y = randomY;
            this.speedY = 1;
            this.radius = 10;
        }
   }

    @Override
    public void render(Graphics graphics) {
        graphics.fillOval(this.x, this.y, this.radius, this.radius);
    }

    @Override
    public void update(float delta) {
        this.y += speedY * delta;

        if (this.y > 1500){
            this.y = 0;
        }

    }
}
