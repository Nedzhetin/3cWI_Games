package at.nejo.StrategyGame.Abilities;
import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;
import org.newdawn.slick.Image;

public class SnowBallAbility extends Ability{
    public SnowBallAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility);
    }


    @Override
    public void draw() {
        if (GameVariables.currentPlayer == GameVariables.player2){
            setAbilityImg(getAbilityImg().getFlippedCopy(true, false));

        }
        getAbilityImg().draw(getX(),getY());

    }
    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {

            opponentPlayer.setHealth(opponentPlayer.getHealth() - this.getAbilityDamage());
            opponentPlayer.setFrozen(true);
            opponentPlayer.setNerfDuration(2);


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
