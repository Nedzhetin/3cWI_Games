package at.nejo.games.firstGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.awt.*;

public class Rectangle implements Shape {
    private float x;
    private float y;
    private float width;
    private float height;
    private double speedX;
    private double speedY;

    public Rectangle(float x, float y, float width, float height, double speedX, double speedY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void update(float delta, GameContainer container) {
        this.x += this.speedX / delta;
        this.y += this.speedY /delta;

        // Check for collisions with the container edges
        if (this.x < 0) {
            this.x = 0; // Correct position
            this.speedX = Math.abs(this.speedX); // Ensure speed is positive
        } else if (this.x + this.width > container.getWidth()) {
            this.x = container.getWidth() - this.width; // Correct position
            this.speedX = -Math.abs(this.speedX); // Ensure speed is negative
        }

        if (this.y < 0) {
            this.y = 0; // Correct position
            this.speedY = Math.abs(this.speedY); // Ensure speed is positive
        } else if (this.y + this.height > container.getHeight()) {
            this.y = container.getHeight() - this.height; // Correct position
            this.speedY = -Math.abs(this.speedY); // Ensure speed is negative
        }
    }

}
