package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.GameVariables;
import at.nejo.StrategyGame.Character;

public class FireBallAbility extends Ability{
    public FireBallAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility, 0);
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
            if (currentPlayer.isFrozen() || currentPlayer.isParalyzed()){
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
                setX(getX() + 0.75f);

            }else{
                setX(getX() -0.75f);

            }

        }
}
