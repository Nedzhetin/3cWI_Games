package at.nejo.rocketGame;


import org.newdawn.slick.*;

public class Rocket implements Figures{
    private Image rocketImg;
    private float x;
    private float y;

    public Rocket(float x, float y) throws SlickException {
        Image tmp = new Image("testdata/rocket.png");
        this. rocketImg = tmp.getScaledCopy(200,200);
        this. x = x;
        this. y = y;
    }

    @Override
    public void draw(Graphics graphics) {
        rocketImg.draw(this.x,this.y);
    }

    @Override
    public void move(float delta, GameContainer container) {

        if (container.getInput().isKeyDown(Input.KEY_A)) {
            this.x--;
        }
        if (container.getInput().isKeyDown(Input.KEY_D)) {
            this.x++;
        }

        if (container.getInput().isKeyDown(Input.KEY_W)) {
            this.y--;
        }
        if (container.getInput().isKeyDown(Input.KEY_S)) {
            this.y++;
        }

        if (this.x + 150 > container.getWidth()) {
            this.x = container.getWidth() - 150;
        }
        if(this.x < 0){
            this.x = 0;
        }

        if (this.y + 150 > container.getHeight()) {
            this.y = container.getHeight() - 150;
        }

        if(this.y < 10){
            this.y = 10;
        }

    }

    public float getX() {
        return x + 90;
    }

    @Override
    public float getHeight() {
        return 0;
    }

    @Override
    public float getWidth() {
        return 0;
    }

    public float getY() {
        return y - 5;
    }
}
