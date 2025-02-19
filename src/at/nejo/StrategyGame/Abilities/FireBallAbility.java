package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.GameVariables;
import at.nejo.StrategyGame.Character;

public class FireBallAbility extends Ability{
    public FireBallAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility, 0);
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer.isFrozen()){
            return;
        }else{
            getAbilityImg().draw(getX(),getY());
        }
    }

    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {
            if (currentPlayer.isFrozen()){
                return;
            }
            if (this.getAbilityCooldown() > 0){
                return;
            }

            opponentPlayer.setHealth(opponentPlayer.getHealth() - this.getAbilityDamage());

    }




    @Override
    public void move() {

            if(GameVariables.currentPlayer == GameVariables.player1){
                setX(getX() + 1);

            }else{
                setX(getX() -1);

            }

        }
}
