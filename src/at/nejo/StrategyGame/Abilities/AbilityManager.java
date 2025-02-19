package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

import java.util.ArrayList;
import java.util.List;

public class AbilityManager {
    private Character currentPlayer;
    private Character opponentPlayer;
    private List<Ability> activeAbilities;
    private boolean canUseAbility;


    public AbilityManager(Character currentPlayer, Character opponentPlayer) {
        this.currentPlayer = currentPlayer;
        this.opponentPlayer = opponentPlayer;
        this.activeAbilities = new ArrayList<Ability>();
        this.canUseAbility = true;
    }

    public void renderAbilities() {
        for (Ability ability : activeAbilities) {
            ability.draw();
        }


    }

    public void ManageAbility(AbilityType abilityType) {
        Ability ability = (abilityType == AbilityType.FIRST) ? currentPlayer.getFirstAbility() : currentPlayer.getSecondAbility();

        if (!ability.isDrawable()){
            if (ability.getAbilityDamage() < 0){
                handleAbilityCooldown(ability);
                ability.ActivateAbility(currentPlayer, opponentPlayer);
                handleNerfEffects(ability);// because heal is not drawable but it still should the check the nerfs
                this.canUseAbility = true;
                changePlayers();

            }

            handleNerfEffects(ability);
           return; // Do nothing if the ability is not drawable
        }



        this.activeAbilities.add(ability);
        positionAbility(ability);
        handleNerfEffects(ability);


    }

    public void updateAbilities() {
        for (int i = activeAbilities.size() - 1; i >= 0; i--) {
            Ability ability = activeAbilities.get(i);
            ability.move();

            // Check if it collides with the opponent
            if (GameVariables.isCollidingAbilityCharacter(ability, GameVariables.opponentPlayer)) {

                handleAbilityCooldown(currentPlayer.getFirstAbility());
                handleAbilityCooldown(currentPlayer.getSecondAbility());
                this.canUseAbility = true;

                ability.ActivateAbility(GameVariables.currentPlayer, GameVariables.opponentPlayer);
                activeAbilities.remove(i); // Remove ability after impact
                changePlayers();
            }
        }
    }

    public void changePlayers() {
        Character temp = GameVariables.currentPlayer;
        GameVariables.currentPlayer = GameVariables.opponentPlayer;
        GameVariables.opponentPlayer = temp;

        // Update the reference inside AbilityManager
        this.currentPlayer = GameVariables.currentPlayer;
        this.opponentPlayer = GameVariables.opponentPlayer;

        // Check if the player is still frozen
        if (this.currentPlayer.getNerfDuration() == 0) {
            this.currentPlayer.setFrozen(false);
        }



    }

    private void  handleAbilityCooldown(Ability ability) {
        if (ability.getAbilityCooldown() > 0) {
            ability.setAbilityCooldown(ability.getAbilityCooldown() - 1);

        }
        if (ability.getAbilityCooldown() == 0 && ability.getAbilityDamage() > 0) {
            // I have to check if it deals any damage because the heal should never be drawable
            ability.setDrawable(true);
        }

    }


    private void handleNerfEffects(Ability ability) {
        if (currentPlayer.getNerfDuration() > 0) {
            currentPlayer.setNerfDuration(currentPlayer.getNerfDuration() - 1);
            System.out.println("Nerf duration: " + currentPlayer.getNerfDuration());
            return;
        }

        if (ability.getAbilityCooldown() > 0) {
            System.out.println("Ability cooldown: " + ability.getAbilityCooldown());
        }

        if (ability.getAbilityCooldown() == 0) {
            ability.setDrawable(true);
        }



       // if the player is frozen is being checked in the ChangePlayers method
    }

    private void positionAbility(Ability ability) {
        if (currentPlayer == GameVariables.player1) {
            ability.setX(currentPlayer.getX() + currentPlayer.getWidth() - 100);
        } else {
            ability.setX(currentPlayer.getX() - currentPlayer.getWidth() + 200);
        }
        ability.setY(currentPlayer.getY() + currentPlayer.getHeight() - 320);

    }

    public boolean canUseAbility() {
        return canUseAbility;
    }

    public void setCanUseAbility(boolean canUseAbility) {
        this.canUseAbility = canUseAbility;
    }


}
