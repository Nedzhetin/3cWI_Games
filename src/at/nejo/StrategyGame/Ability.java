package at.nejo.StrategyGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tests.ImageGraphicsTest;

public class Ability implements Content {
    private int abilityDamage;
    private float x;
    private float y;
    private int width = 300;
    private int height = 300;
    private Image abilityImg;

    public Ability(int abilityDamage,String imgUrl) {
        this.abilityDamage = abilityDamage;

        try {
            this.abilityImg = new Image(imgUrl);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }

        this.abilityImg = this.abilityImg.getScaledCopy(this.width,this.height);

    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer == GameVariables.player2){
            this. abilityImg = this.abilityImg.getFlippedCopy(true,false);
        }

        this.abilityImg.draw(this.x, this.y);

    }


    public void move(){
        if(GameVariables.currentPlayer == GameVariables.player1){
            this.x += 1;

        }else{
            this.x -= 1;
        }
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getAbilityDamage() {
        return abilityDamage;
    }

    public void setAbilityDamage(int abilityDamage) {
        this.abilityDamage = abilityDamage;
    }

    public void setY(float y) {
        this.y = y;
    }
}
