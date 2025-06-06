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
    public void activateAbility(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {
                if (this.getAbilityCooldown() > 0 || currentPlayer.isParalyzed() || currentPlayer.isFrozen()) {
                    abilityManager.setCanUseAbility(true);
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
        opponentPlayer.setFrozen(true);
        opponentPlayer.setNerfDuration(2);
        this.setAbilityCooldown(6);
        this.setDrawable(false);

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
