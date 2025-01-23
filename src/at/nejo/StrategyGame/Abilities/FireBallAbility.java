package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.GameVariables;

public class FireBallAbility extends Ability{
    public FireBallAbility(int abilityDamage, String imgUrl) {
        super(abilityDamage, imgUrl);
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer == GameVariables.player2){
            setAbilityImg(getAbilityImg().getFlippedCopy(true, false));

        }
        getAbilityImg().draw(getX(),getY());

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
