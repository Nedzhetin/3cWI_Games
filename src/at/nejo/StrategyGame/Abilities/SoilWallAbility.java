package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;
import org.newdawn.slick.Color;

public class SoilWallAbility extends Ability{

    private int health;
    private boolean isPositioned;

    public SoilWallAbility(int abilityDamage, String imgUrl, boolean drawAbility, int health) {
        super(abilityDamage, imgUrl, drawAbility,0);
        this.health = health;
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer.isFrozen()){
            return;
        }

        if(GameVariables.player1 == GameVariables.earthMan){
            getAbilityImg().draw(getX() + 50, getY() + 50);
        }else if(GameVariables.player2 == GameVariables.earthMan){
            getAbilityImg().draw(getX() + 180, getY() + 50);

        }


        if(GameVariables.earthMan == GameVariables.player1) {
            if (this.health > 30){
                GameVariables.font.drawString(this.getX() + 150, this.getY(),  ""+ this.health, Color.green);
            }else if (this.health > 15){
                GameVariables.font.drawString(this.getX() + 150 , this.getY(),  ""+ this.health,Color.yellow);
            }else{
                GameVariables.font.drawString(this.getX() + 150, this.getY(),  ""+ this.health,Color.red);
            }
        }else{
            if (this.health > 30){
                GameVariables.font.drawString(this.getX() + this.getWidth(), this.getY(),  ""+ this.health, Color.green);
            }else if (this.health > 15){
                GameVariables.font.drawString(this.getX() + this.getWidth(), this.getY(),  ""+ this.health,Color.yellow);
            }else{
                GameVariables.font.drawString(this.getX() + this.getWidth(), this.getY(),  ""+ this.health,Color.red);
            }
        }

    }

    public void activateAbility(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {
        if (currentPlayer.isFrozen()) {
            abilityManager.handleNerfEffects(this);
            abilityManager.changePlayers();
            return;
        }
        if (this.getAbilityCooldown() > 0) {
            abilityManager.setCanUseAbility(true);
            return;
        }

        // Check if it's already active to prevent repositioning
        if (abilityManager.getActiveSoilWall() == null) {
            abilityManager.addActiveAbility(this);
            abilityManager.setActiveSoilWall(this);
            abilityManager.positionAbility(this);
            this.isPositioned = true;
        }

        abilityManager.handleNerfEffects(this);
        abilityManager.setCanUseAbility(true);
        abilityManager.changePlayers();
        this.setAbilityCooldown(5);
    }

    @Override
    public void dealDamage(Character currentPlayer, Character opponentPlayer) {

    }


    @Override
    public void move() {

    }

    public boolean isPositioned() {
        return isPositioned;
    }

    public void setPositioned(boolean positioned) {
        isPositioned = positioned;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

}
