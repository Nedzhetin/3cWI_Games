package at.nejo.StrategyGame.Abilities;
import at.nejo.StrategyGame.Character;

public class HealAbility extends Ability{
    public HealAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility);
    }

    @Override
    public void draw() {

    }

    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {
        if (currentPlayer.getNerfDuration() == 0){
            currentPlayer.setHealth(currentPlayer.getHealth() - this.getAbilityDamage());
        }
    }



    @Override
    public void move() {

    }
}
