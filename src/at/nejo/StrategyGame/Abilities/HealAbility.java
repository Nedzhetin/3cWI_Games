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
    public void activateAbility(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {
        if (currentPlayer.isFrozen()){
            abilityManager.changePlayers();
            return;
        }
        if (this.getAbilityCooldown() > 0){
            return;
        }

        currentPlayer.setHealth(currentPlayer.getHealth() - this.getAbilityDamage());
        setAbilityCooldown(4);
        abilityManager.changePlayers();
    }

    @Override
    public void dealDamage(Character currentPlayer, Character opponentPlayer) {


    }


    @Override
    public void move() {

    }
}
