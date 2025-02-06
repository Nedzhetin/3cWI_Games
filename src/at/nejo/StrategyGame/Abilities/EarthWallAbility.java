package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;

public class EarthWallAbility extends Ability{
    public EarthWallAbility(int abilityDamage, String imgUrl, boolean drawAbility) {
        super(abilityDamage, imgUrl, drawAbility,0);
    }

    @Override
    public void draw() {

    }

    @Override
    public void ActivateAbility(Character currentPlayer, Character opponentPlayer) {

    }

    @Override
    public void move() {

    }
}
