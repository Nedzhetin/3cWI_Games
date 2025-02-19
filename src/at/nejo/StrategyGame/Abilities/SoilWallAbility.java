package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;

public class SoilWallAbility extends Ability{
    public SoilWallAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility,0);
    }

    @Override
    public void draw() {
        getAbilityImg().draw(getX(),getY());

    }

    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {

    }

    @Override
    public void move() {

    }
}
