package at.nejo.StrategyGame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Character implements Content {
    private Image characterImg;
    private float x;
    private float y;
    private final String name;
    private int health;
    private final int width = 300;
    private final int height = 300;
    public enum TYPE {FIRE,ICE,EARTH,WIND,LIGHTING,WATER}
    private TYPE type;


    public Character(String name,int health,TYPE type,String imgUrl,float x, float y) {


        try {
            this.characterImg = new Image(imgUrl);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
        this.characterImg = this.characterImg.getScaledCopy(this.width,this.height);
        this.x = x;
        this.y = y;
        this.name = name;
        this.health = health;
        this.type = type;
    }

    @Override
    public void draw() {
        this.characterImg.draw(this.x, this.y);

        if (GameVariables.player1 != null && GameVariables.player2 != null) {

        }
    }

    public void drawHealthBar(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.drawRect(this.x,this.y - this.height /2,this.width,20);
        graphics.setColor(Color.green);
        graphics.fillRect(this.x + 2,this.y - this.height /2 + 2,this.health,18);
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

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public Image getCharacterImg() {
        return characterImg;
    }

    public void setCharacterImg(Image characterImg) {
        this.characterImg = characterImg;
    }
}
