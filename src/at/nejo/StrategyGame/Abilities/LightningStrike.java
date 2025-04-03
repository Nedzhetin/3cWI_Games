package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

public class LightningStrike extends Ability{
    public LightningStrike(int abilityDamage, String imgUrl, boolean isDrawable, int abilityCooldown) {
        super(abilityDamage, imgUrl, isDrawable, abilityCooldown);
    }

    @Override
    public void draw() {
        if (GameVariables.currentPlayer.isFrozen()) {
            return;
        }
       // getAbilityImg().draw(GameVariables.opponentPlayer.getX(),GameVariables.opponentPlayer.getY() -1000);

        if(GameVariables.currentPlayer == GameVariables.player1) {
            getAbilityImg().draw(getX() + 850,getY() -1500);

        }
        else{
            getAbilityImg().draw(getX() - 870,getY() - 1500);

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

    }

    @Override
    public void move() {
        setY(getY() + 1.5f);
        if(GameVariables.currentPlayer == GameVariables.player1) {
            setX(getX() - 0.07f);
        }else{
            setX(getX() + 0.07f);
        }
    }
    }

