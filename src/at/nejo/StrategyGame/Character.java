package at.nejo.StrategyGame;

import at.nejo.StrategyGame.Abilities.Ability;
import org.newdawn.slick.*;

public class Character implements Content {
    private Image characterImg;
    private float x;
    private float y;
    private final String name;
    private int health;
    private final int width = 450;
    private final int height = 450;
    public enum TYPE {FIRE,ICE,EARTH,WIND,LIGHTNING,WATER}
    private TYPE type;
    private boolean isFrozen;
    private int nerfDuration;

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
        this.isFrozen = false;
        this.nerfDuration = 0;
    }

    @Override
    public void draw() {
        if (isBig){
           this.characterImg = this.characterImg.getScaledCopy(500,500);
        }


        if (isFrozen){
            GameVariables.frozenImg.draw(this.x,this.y);
        }else{
            this.characterImg.draw(this.x, this.y);

        }
    }

    public void drawHealth(Graphics graphics) {

        if (this.health > 60){
            GameVariables.font.drawString(this.x + this.width/2, this.y - this.height/2,  ""+ this.health,Color.green);
        }else if (this.health > 30){
            GameVariables.font.drawString(this.x + this.width/2, this.y - this.height/2,  ""+ this.health,Color.yellow);
        }else{
            GameVariables.font.drawString(this.x + this.width/2, this.y - this.height/2,  ""+ this.health,Color.red);
        }



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

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
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

    public int getNerfDuration() {
        return nerfDuration;
    }

    public void setNerfDuration(int nerfDuration) {
        this.nerfDuration = nerfDuration;
    }
}
