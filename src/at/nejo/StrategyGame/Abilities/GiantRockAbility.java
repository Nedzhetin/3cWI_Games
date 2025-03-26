package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

public class GiantRockAbility extends Ability{

    private boolean goingUp = true;

    public GiantRockAbility(int abilityDamage, String imgUrl, boolean isDrawable) {
        super(abilityDamage, imgUrl, isDrawable, 0);
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer.isFrozen()){
            return;
        }else{
            getAbilityImg().draw(getX() + 100,getY() - 400);
        }
    }

    @Override
    public void activateAbility(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {
        if (currentPlayer.isFrozen()){
            abilityManager.handleNerfEffects(this);
            abilityManager.changePlayers();
            return;
        }
        abilityManager.addActiveAbility(this);
        abilityManager.positionAbility(this);
        abilityManager.handleNerfEffects(this);
        this.goingUp = true;
    }

    @Override
    public void dealDamage(Character currentPlayer, Character opponentPlayer) {
        opponentPlayer.setHealth(opponentPlayer.getHealth() - this.getAbilityDamage());

    }

    @Override
    public void move() {
        if (GameVariables.currentPlayer == GameVariables.player1) {
            setX(getX() + 0.5f);
        } else {
            setX(getX() - 0.5f);
        }


        if (goingUp) {
            setY(getY() - 0.5f);
            if (getY() <= 400) {
                goingUp = false;
            }
        } else {
            setY(getY() + 0.5f);

        }
    }

    public boolean isGoingUp() {
        return goingUp;
    }

    public void setGoingUp(boolean goingUp) {
        this.goingUp = goingUp;
    }
}
