package at.nejo.rocketGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Boss implements Figures {
   private Image bossImg;
    private float x,y;

    public Boss( float x, float y) throws SlickException {
        Image tmp = new Image("testdata/alienSpaceShip.png");
        this. bossImg = tmp.getScaledCopy(800,800);
        this. x = x;
        this. y = y;
    }



    @Override
    public void draw(Graphics graphics) {
        bossImg.draw(this.x, this.y);
    }

    @Override
    public void move(float delta, GameContainer container) {

        if (this.y <= -200) {
            this.y++;
        }else{
            this.y = -200;
        }
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getHeight() {
        return 0;
    }

    @Override
    public float getWidth() {
        return 0;
    }
}
