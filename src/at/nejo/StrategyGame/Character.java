package at.nejo.StrategyGame;

import at.nejo.StrategyGame.Abilities.Ability;
import org.newdawn.slick.*;

public class Character implements Content {
    private Image characterImg;
    private float x;
    private float y;
    private final String name;
    private int health;
    private final int width = 300;
    private final int height = 300;
    public enum TYPE {FIRE,ICE,EARTH,WIND,LIGHTNING,WATER}
    private TYPE type;

    private boolean isBig;
    private Ability firstAbility;
    private Ability secondAbility;


    public Character(String name,int health,TYPE type,String imgUrl,float x, float y,Ability firstAbility,Ability secondAbility) {


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
        this.firstAbility = firstAbility;
        this.secondAbility = secondAbility;
    }

    @Override
    public void draw() {
        if (isBig){
           this.characterImg = this.characterImg.getScaledCopy(500,500);
        }

        this.characterImg.draw(this.x, this.y);

        if (GameVariables.player1 != null && GameVariables.player2 != null) {

        }
    }

    public void drawHealthBar(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.drawRect(this.x +120,this.y - this.height /2,this.width,25);
        graphics.setColor(Color.green);
        graphics.fillRect(this.x + 122,this.y - this.height /2 + 2,this.health,23);
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

    public boolean isBig() {
        return isBig;
    }

    public void setBig(boolean big) {
        isBig = big;
    }

    public Ability getFirstAbility() {
        return firstAbility;
    }

    public Ability getSecondAbility() {
        return secondAbility;
    }


}
