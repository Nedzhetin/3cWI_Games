package at.nejo.rocketGame;

import org.newdawn.slick.*;

public class Boss implements Figures {
   private Image bossImg;
   private float x,y;
   private int bosslifes;
   private int width,height;
   private double speedX;
   private AngelCodeFont font = new AngelCodeFont("testdata/hiero.fnt","testdata/hiero.png");



    public Boss( float x, float y) throws SlickException {
        Image tmp = new Image("testdata/ufoImg.png");
        this.x = x;
        this.width = 800;
        this.height = 800;
        this. bossImg = tmp.getScaledCopy(800,350);
        this. y = y;
        this.bosslifes = 50;
        this.speedX = 1.1;
    }


    @Override
    public void draw(Graphics graphics) {
        bossImg.draw(this.x, this.y);
        font.drawString(this.x + this.width/2 -20,this.y + this.height/2 -280,"" + this.bosslifes);
    }

    @Override
    public void move(float delta, GameContainer container) {

        if (this.y == 20) {
            this.x += this.speedX / delta;

            if (this.x < 0) {
                this.x = 0; // Correct position
                this.speedX = Math.abs(this.speedX); // Ensure speed is positive
            } else if (this.x + this.width > container.getWidth()) {
                this.x = container.getWidth() - this.width; // Correct position
                this.speedX = -Math.abs(this.speedX); // Ensure speed is negative
            }

        }else{
           this.y += 0.8;
        }



    }

    public int getBosslifes() {
        return bosslifes;
    }

    public void setBosslifes(int bosslifes) {
        this.bosslifes = bosslifes;
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
        return this.height - 450;
    }

    @Override
    public float getWidth() {
        return this.width;
    }




}
