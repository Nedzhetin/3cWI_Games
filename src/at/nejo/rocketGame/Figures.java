package at.nejo.rocketGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Figures {
    public void draw(Graphics graphics);
    public void move(float delta, GameContainer container);
    public float getY();
    public float getX();
    public float getHeight();
    public float getWidth();
}