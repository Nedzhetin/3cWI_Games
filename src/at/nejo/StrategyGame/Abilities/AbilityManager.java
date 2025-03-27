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
    private SoilWallAbility activeSoilWall;


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

        // If SoilWall already exists, don't create a new one or reposition it
        if (ability instanceof SoilWallAbility && activeSoilWall != null) {
            this.canUseAbility = true;
            System.out.println("SoilWall already active, no repositioning.");
            return;
        }
        ability.activateAbility(currentPlayer, opponentPlayer, this);

    }


    public void updateAbilities() {
        for (int i = activeAbilities.size() - 1; i >= 0; i--) {
            Ability ability = activeAbilities.get(i);
            ability.move();


            // Check if the SoilWall exists and gets hit
            if (activeSoilWall != null && GameVariables.isCollidingAbilityAbility(ability, activeSoilWall)) {
                if(ability instanceof GiantRockAbility){
                    return;
                }
                activeSoilWall.takeDamage(ability.getAbilityDamage());
                if (!(ability instanceof SoilWallAbility)) {
                    activeAbilities.remove(i);// Remove ability after impact
                    changePlayers();
                }
                this.canUseAbility = true;

                return; // Stop checking
            }

            // Check if it collides with the opponent
            if (GameVariables.isCollidingAbilityCharacter(ability, GameVariables.opponentPlayer)) {
                this.canUseAbility = true;
                ability.dealDamage(currentPlayer, opponentPlayer);
                activeAbilities.remove(i);// Remove ability after impact
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
        System.out.println("Nerf duration: " + this.currentPlayer.getNerfDuration());
        if (this.currentPlayer.getNerfDuration() == 0) {
            this.currentPlayer.setFrozen(false);
        }

        this.canUseAbility = true;
        handleAbilityCooldown(currentPlayer.getFirstAbility());
        handleAbilityCooldown(currentPlayer.getSecondAbility());

        if (activeSoilWall != null && activeSoilWall.getHealth() <= 0) {
            activeAbilities.remove(activeSoilWall);
            activeSoilWall.setHealth(50);
            activeSoilWall = null;

            System.out.println("SoilWall destroyed!");
        }
    }

    private void handleAbilityCooldown(Ability ability) {
        if (ability.getAbilityCooldown() > 0) {
            ability.setAbilityCooldown(ability.getAbilityCooldown() - 1);

        }
        if (ability.getAbilityCooldown() == 0 && ability.getAbilityDamage() > 0) {
            // I have to check if it deals any damage because the heal should never be drawable
            ability.setDrawable(true);
        }

    }


    public void handleNerfEffects(Ability ability) {
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

    public void positionAbility(Ability ability) {
        if (currentPlayer == GameVariables.player1) {
            if (ability instanceof SoilWallAbility) {
                ability.setX(600);
                System.out.println("SoilWall created!");
            } else {
                ability.setX(currentPlayer.getX() + currentPlayer.getWidth() - 150);
            }
        } else {
            if (ability instanceof SoilWallAbility) {
                ability.setX(800);
                System.out.println("SoilWall created!");
            } else {
                ability.setX(currentPlayer.getX() - 250);
            }
        }
        ability.setY(currentPlayer.getY() + currentPlayer.getHeight() - 320);
    }

    public boolean canUseAbility() {
        return canUseAbility;
    }

    public void addActiveAbility(Ability ability) {
        this.activeAbilities.add(ability);
    }

    public void setCanUseAbility(boolean canUseAbility) {
        this.canUseAbility = canUseAbility;
    }

    public Character getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Character currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Ability> getActiveAbilities() {
        return activeAbilities;
    }

    public void setActiveAbilities(List<Ability> activeAbilities) {
        this.activeAbilities = activeAbilities;
    }

    public Character getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Character opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }

    public boolean isCanUseAbility() {
        return canUseAbility;
    }

    public SoilWallAbility getActiveSoilWall() {
        return activeSoilWall;
    }

    public void setActiveSoilWall(SoilWallAbility activeSoilWall) {
        this.activeSoilWall = activeSoilWall;
    }

}
