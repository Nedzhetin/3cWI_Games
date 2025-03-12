package at.nejo.snowWorld;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Shape {
     void render(Graphics graphics);
     void update(float delta);
}
