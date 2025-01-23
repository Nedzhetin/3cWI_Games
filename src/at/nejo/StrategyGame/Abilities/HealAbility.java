package at.nejo.StrategyGame.Abilities;
import at.nejo.StrategyGame.Character;

public class HealAbility extends Ability{
    public HealAbility(int abilityDamage, String imgUrl) {
        super(abilityDamage, imgUrl);
    }

    @Override
    public void draw() {

    }

    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {
        currentPlayer.setHealth(currentPlayer.getHealth() - this.getAbilityDamage());
    }



    @Override
    public void move() {

    }
}
