package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

public class SoilWallAbility extends Ability{
    public SoilWallAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility,0);
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer.isFrozen()){
            return;
        }else{
            if (GameVariables.currentPlayer == GameVariables.player1){
                getAbilityImg().draw(getX() + 100,getY()+100);
            }else{
                getAbilityImg().draw(getX() -50,getY()+100);
            }
        }


    }

    @Override
    public void activateAbility(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {
        if (currentPlayer.isFrozen()){
            return;
        }
        if (this.getAbilityCooldown() > 0){
            return;
        }



    }

    @Override
    public void dealDamage(Character currentPlayer, Character opponentPlayer) {

    }


    @Override
    public void move() {

    }

}
