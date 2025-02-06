package at.nejo.StrategyGame.Abilities;
import at.nejo.StrategyGame.Character;

public class HealAbility extends Ability{
    public HealAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility, -1);
    }

    @Override
    public void draw() {

    }

    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {
        if (currentPlayer.isFrozen()){
            return;
        }
            currentPlayer.setHealth(currentPlayer.getHealth() - this.getAbilityDamage());

    }



    @Override
    public void move() {

    }
}
