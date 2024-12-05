package at.nejo.rocketGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Projectiles implements Figures {
    private float x;
    private float y;
    private int hight, width;
    private float speedY, speedX;
    private int colorSelection;

    public Projectiles(float x, float y, int hight, int width, float speedX, float speedY, int colorSelection) {
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.width = width;
        this.speedX = speedX;
        this.speedY = speedY;
        this.colorSelection = colorSelection;

    }

    @Override
    public void draw(Graphics graphics) {
        if (this.colorSelection == 0) {
            graphics.setColor(Color.white);
        } else {
            graphics.setColor(Color.green);
        }
        graphics.fillOval(this.x, this.y, this.width, this.hight);

    }

    @Override
    public void move(float delta, GameContainer container) {
        this.y += speedY;
        this.x += speedX;


    }

    @Override
    public float getY() {
        return y;
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
}

