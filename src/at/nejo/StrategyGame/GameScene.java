package at.nejo.StrategyGame;

import at.nejo.StrategyGame.Abilities.Ability;
import at.nejo.StrategyGame.Abilities.AbilityManager;
import at.nejo.StrategyGame.Abilities.AbilityType;
import org.lwjgl.Sys;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameScene extends BasicGameState {

    private int stateId;
    private AbilityManager abilityManager;


    public GameScene(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {


        GameVariables.backgroundImg.draw();
        GameVariables.player1.drawAbilityBtns(graphics,GameVariables.currentPlayer, GameVariables.opponentPlayer);
        GameVariables.player2.drawAbilityBtns(graphics,GameVariables.currentPlayer, GameVariables.opponentPlayer);



        GameVariables.player1.setXY(200,500);
        GameVariables.player1.draw();
        GameVariables.player1.drawHealth(graphics);

        GameVariables.player2.setXY(1200,500);
        GameVariables.player2.draw();
        GameVariables.player2.drawHealth(graphics);

        if (GameVariables.gameOver) {
            GameVariables.largeFont.drawString(800, 600, GameVariables.player1.getHealth() <= 0 ? "Player 2 wins!" : "Player 1 wins!", Color.black);
            return; // Stop further updates
        }

        abilityManager.renderAbilities();


        if (GameVariables.currentPlayer == GameVariables.player1) {
            GameVariables.largeFont.drawString(800,100,"Player 1 turn",Color.black);
        }else{
            GameVariables.largeFont.drawString(800,100,"Player 2 turn",Color.black);

        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {


        if (this.abilityManager == null && GameVariables.currentPlayer != null && GameVariables.opponentPlayer != null) {
            this.abilityManager = new AbilityManager(GameVariables.currentPlayer, GameVariables.opponentPlayer);
        }

        abilityManager.updateAbilities();

    }


    public void mouseClicked(int button, int x, int y, int clickCount) {
        for (Content content : GameVariables.contents) {
            if(content instanceof Character) {
                if(GameVariables.isColliding(x,y,content)) {

                    System.out.println(((Character) content).getHealth());
                }
            }
        }
    }


   public void keyPressed(int key, char c) {
        if (key == Input.KEY_1) {
            if(GameVariables.gameOver){
                return;
            }
            if (abilityManager.canUseAbility()){
                abilityManager.setCanUseAbility(false);
                abilityManager.ManageAbility(AbilityType.FIRST);
            }

        }
        if (key == Input.KEY_2){
            if(GameVariables.gameOver){
                return;
            }
            if (abilityManager.canUseAbility()){
                abilityManager.setCanUseAbility(false);
                abilityManager.ManageAbility(AbilityType.SECOND);
            }

        }

   }


    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);

        for (Content content : GameVariables.contents) {
            if(content instanceof Character) {
                if(GameVariables.isColliding(oldx,oldy,content)) {

                    System.out.println(((Character) content).getHealth());
                }
            }
        }

        for (Content content : GameVariables.contents) {
            if (content instanceof Ability) {
                if (GameVariables.isHoveringMouseAbility(oldx, oldy, (Ability) content)) {
                    System.out.println("Ability is hovered");
                }
            }

        }

    }
}
