package at.nejo.rocketGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Projectiles implements Figures {
    private float x;
    private float y;
    private int hight, width;

    public Projectiles(float x, float y, int hight, int width) {
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.width = width;
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.fillOval(this.x, this.y, this.width, this.hight);

    }

    @Override
    public void move(float delta, GameContainer container) {
        this.y--;

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

