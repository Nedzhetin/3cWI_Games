package at.nejo.StrategyGame.Abilities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import at.nejo.StrategyGame.Character;

public abstract class Ability  {
    private int abilityDamage;
    private float x;
    private float y;
    private int width = 300;
    private int height = 300;
    private boolean isDrawable;
    private Image abilityImg;
    private int abilityCooldown;

    public Ability(int abilityDamage, String imgUrl, boolean isDrawable, int abilityCooldown) {
        this.abilityDamage = abilityDamage;
        this.isDrawable = isDrawable;
        this.abilityCooldown = abilityCooldown;

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
    public abstract void activateAbility(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager);
    public abstract void dealDamage(Character currentPlayer, Character opponentPlayer);

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

    public boolean isDrawable() {
        return this.isDrawable;
    }

    public void setDrawable(boolean drawable) {
        this.isDrawable = drawable;
    }

    public int getHeight() {
        return this.height;
    }



    public int getAbilityCooldown() {
        return this.abilityCooldown;
    }

    public void setAbilityCooldown(int abilityCooldown) {
        this.abilityCooldown = abilityCooldown;
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
