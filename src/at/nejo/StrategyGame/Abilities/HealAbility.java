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
        if (this.getAbilityCooldown() > 0){
            return;
        }
            currentPlayer.setHealth(currentPlayer.getHealth() - this.getAbilityDamage());
            setAbilityCooldown(4);

    }

    @Override
    public void activate(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {

    }


    @Override
    public void move() {

    }
}
