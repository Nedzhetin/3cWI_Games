package at.nejo.StrategyGame.Abilities;

import at.nejo.StrategyGame.Character;
import at.nejo.StrategyGame.GameVariables;

import java.util.ArrayList;
import java.util.List;

public class AbilityManager {
    private Character currentPlayer;
    private Character opponentPlayer;
    private List<Ability> activeAbilities;

    public AbilityManager(Character currentPlayer, Character opponentPlayer) {
        this.currentPlayer = currentPlayer;
        this.opponentPlayer = opponentPlayer;
        this.activeAbilities = new ArrayList<Ability>();
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
                ability.ActivateAbility(currentPlayer, opponentPlayer);
                changePlayers();
            }
           return; // Do nothing if the ability is not drawable
        }

        if (currentPlayer == GameVariables.player2) {
            ability.setAbilityImg(ability.getAbilityImg().getFlippedCopy(true, false));
        }

        this.activeAbilities.add(ability);
        positionAbility(ability);

    }

    public void updateAbilities() {
        for (int i = activeAbilities.size() - 1; i >= 0; i--) {
            Ability ability = activeAbilities.get(i);
            ability.move();

            // Check if it collides with the opponent
            if (GameVariables.isCollidingAbilityCharacter(ability, GameVariables.opponentPlayer)) {
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
    }


    private void handleNerfEffects() {
        if (currentPlayer.getNerfDuration() > 0) {
            currentPlayer.setNerfDuration(currentPlayer.getNerfDuration() - 1);
        }

        if (currentPlayer.getNerfDuration() == 0) {
            currentPlayer.setFrozen(false);
        }
    }

    private void positionAbility(Ability ability) {
        if (currentPlayer == GameVariables.player1) {
            ability.setX(currentPlayer.getX() + currentPlayer.getWidth() - 100);
        } else {
            ability.setX(currentPlayer.getX() - currentPlayer.getWidth() + 200);
        }
        ability.setY(currentPlayer.getY() + currentPlayer.getHeight() - 320);

    }

}
