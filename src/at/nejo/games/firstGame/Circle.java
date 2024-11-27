package at.nejo.games.firstGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Circle implements Shape {
   private float x, y;
   private float radius;
   private double speedX;
   private double speedY;

   public Circle(float x, float y, float radius, double speedX, double speedY) {
       this.x = x;
       this.y = y;
       this.radius = radius;
       this.speedX = speedX;
       this.speedY = speedY;
   }



    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.radius, this.radius);
    }

    @Override
    public void update(float delta, GameContainer container) {
        this.x += this.speedX * delta;
        this.y += this.speedY * delta;

        // Check for collisions with the container edges
        if (this.x < 0) {
            this.x = 0; // Correct position
            this.speedX = Math.abs(this.speedX); // Ensure speed is positive
        } else if (this.x + this.radius > container.getWidth()) {
            this.x = container.getWidth() - this.radius; // Correct position
            this.speedX = -Math.abs(this.speedX); // Ensure speed is negative
        }

        if (this.y < 0) {
            this.y = 0; // Correct position
            this.speedY = Math.abs(this.speedY); // Ensure speed is positive
        } else if (this.y + this.radius > container.getHeight()) {
            this.y = container.getHeight() - this.radius; // Correct position
            this.speedY = -Math.abs(this.speedY); // Ensure speed is negative
        }
    }
}
