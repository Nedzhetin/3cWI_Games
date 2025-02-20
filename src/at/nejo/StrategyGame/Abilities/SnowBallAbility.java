package at.nejo.StrategyGame.Abilities;
import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

public class SnowBallAbility extends Ability{

    public SnowBallAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility, 0);
        if (GameVariables.currentPlayer == GameVariables.player2){
            setAbilityImg(getAbilityImg().getFlippedCopy(true, false));

        }
    }


    @Override
    public void draw() {

        getAbilityImg().draw(getX(),getY());

    }
    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {
                if (this.getAbilityCooldown() > 0){
                    return;
                }

        opponentPlayer.setHealth(opponentPlayer.getHealth() - this.getAbilityDamage());
        opponentPlayer.setFrozen(true);
        opponentPlayer.setNerfDuration(2);
        this.setAbilityCooldown(3);
        this.setDrawable(false);

    }

    @Override
    public void activate(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {

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
