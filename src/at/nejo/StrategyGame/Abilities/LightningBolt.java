package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

public class LightningBolt extends Ability{
    public LightningBolt(int abilityDamage, String imgUrl, boolean isDrawable, int abilityCooldown) {
        super(abilityDamage, imgUrl, isDrawable, abilityCooldown);
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer.isFrozen()) {
            return;
        }

        if(GameVariables.currentPlayer == GameVariables.player1) {
            getAbilityImg().draw(getX(), getY());
        }
        else{
            getAbilityImg().draw(getX() + 100,getY());
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
    }

    @Override
    public void dealDamage(Character currentPlayer, Character opponentPlayer) {
        opponentPlayer.setHealth(opponentPlayer.getHealth() - this.getAbilityDamage());

    }

    @Override
    public void move() {

        if(GameVariables.currentPlayer == GameVariables.player1){
            setX(getX() + 3.5f);

        }else{
            setX(getX() -3.5f);

        }

    }
}

