package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

public class GiantRockAbility extends Ability{

    private float gravity = 0.001f;
    private float velocityX = 0.48f;
    private float velocityY = -0.5f;

    public GiantRockAbility(int abilityDamage, String imgUrl, boolean isDrawable) {
        super(abilityDamage, imgUrl, isDrawable, 0);
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer.isFrozen()){
            return;
        }else{
            getAbilityImg().draw(getX() + 100,getY() - 400);
        }
    }

    @Override
    public void activateAbility(Character currentPlayer, Character opponentPlayer, AbilityManager abilityManager) {
        if (currentPlayer.isFrozen()){
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
        this.velocityY = -0.5f;

    }

    @Override
    public void move() {
        // Apply horizontal movement
        if(GameVariables.currentPlayer == GameVariables.player1){
            setX(getX() + velocityX);

        }else{
            setX(getX() -velocityX);

        }
        // Apply gravity for smooth downward movement
        velocityY += gravity;
        setY(getY() + velocityY);


    }

}
