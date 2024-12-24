package at.nejo.StrategyGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Character implements Content {
    private final Image characterImg;
    private float x;
    private float y;
    private final String name;
    private int health;
    private final int width = 300;
    private final int height = 300;
    public enum TYPE {FIRE,ICE,EARTH,WIND,LIGHTING,WATER}
    private TYPE type;


    public Character(String name,int health,TYPE type,String imgUrl,float x, float y) {

        Image tmp = null;
        try {
            tmp = new Image(imgUrl);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
        this.characterImg = tmp.getScaledCopy(this.width,this.height);
        this.x = x;
        this.y = y;
        this.name = name;
        this.health = health;
        this.type = type;
    }

    @Override
    public void draw() {
        characterImg.draw(this.x, this.y);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }


}
