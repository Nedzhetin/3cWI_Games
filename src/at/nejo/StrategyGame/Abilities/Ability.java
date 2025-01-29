package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Content;
import at.nejo.StrategyGame.GameVariables;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import at.nejo.StrategyGame.Character;

public abstract class Ability  {
    private int abilityDamage;
    private float x;
    private float y;
    private int width = 300;
    private int height = 300;
    private boolean drawAbility;
    private Image abilityImg;

    public Ability(int abilityDamage,String imgUrl, boolean drawAbility) {
        this.abilityDamage = abilityDamage;
        this.drawAbility = drawAbility;

        if(imgUrl != ""){

        try {
            this.abilityImg = new Image(imgUrl);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
            this.abilityImg = this.abilityImg.getScaledCopy(this.width,this.height);

        }

    }



    public abstract void draw();
    public abstract void ActivateAbility(Character currentPlayer, Character opponentPlayer);

    public void drawAbility(Image img) {
        this.abilityImg.draw(this.x, this.y);

    }



    public abstract void move();


    public float getX() {
        return this.x;
    }


    public float getY() {
        return this.y;
    }


    public int getWidth() {
        return this.width;
    }

    public boolean isDrawAbility() {
        return this.drawAbility;
    }


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

    public Image getAbilityImg() {
        return abilityImg;
    }

    public void setAbilityImg(Image abilityImg) {
        this.abilityImg = abilityImg;
    }
}
