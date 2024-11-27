package at.nejo.games.firstGame;

import org.newdawn.slick.*;

public class Rocket implements Shape {
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
    public void render(Graphics graphics) {
        rocketImg.draw(this.x,this.y);
    }

    @Override
    public void update(float delta, GameContainer container) {

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

    }
}
