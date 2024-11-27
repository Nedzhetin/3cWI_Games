package at.nejo.games.firstGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Shape {
    public void render(Graphics graphics);
    public void update(float delta, GameContainer container);
}
