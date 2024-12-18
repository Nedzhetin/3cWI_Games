package at.nejo.StrategyGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Character implements Content {
    private Image characterImg;
    private float x;
    private float y;
    private String name;
    private int health;
    public enum TYPE {FIRE,ICE,EARTH,WIND,LIGHTING}
    private TYPE type;


    public Character(String name,int health,TYPE type,String imgUrl,float x, float y) throws SlickException {
        Image tmp = new Image(imgUrl);
        this.characterImg = tmp.getScaledCopy(400,400);
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
}
