package at.nejo.StrategyGame;

import net.java.games.input.Component;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

public class GameScene extends BasicGameState {

    private int stateId;
    private boolean drawAbility;


    public GameScene(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.drawAbility = false;

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        GameVariables.backgroundImg.draw();


        if (this.drawAbility) {

            GameVariables.currentPlayer.getFirstAbility().draw();
            GameVariables.currentPlayer.getSecondAbility().move();


            if (GameVariables.isCollidingAbilityCharacter(GameVariables.currentPlayer.getFirstAbility(),GameVariables.opponentPlayer)){
                GameVariables.opponentPlayer.setHealth(GameVariables.opponentPlayer.getHealth() - 10);
                changePLayers();
                this.drawAbility = false;
            }
        }





        GameVariables.player1.setXY(200,500);
        GameVariables.player1.draw();
        GameVariables.player1.drawHealthBar(graphics);

        GameVariables.player2.setXY(1200,500);
        GameVariables.player2.draw();
        GameVariables.player2.drawHealthBar(graphics);

        if (GameVariables.currentPlayer == GameVariables.player1) {
            GameVariables.font.drawString(800,100,"Player 1 turn");
        }else{
            GameVariables.font.drawString(800,100,"Player 2 turn");
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {


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
            if (GameVariables.currentPlayer == GameVariables.player1) {
                GameVariables.currentPlayer.getFirstAbility().setX(GameVariables.currentPlayer.getX() + GameVariables.currentPlayer.getWidth() + 10);
                GameVariables.currentPlayer.getFirstAbility().setY(GameVariables.currentPlayer.getY() + GameVariables.currentPlayer.getHeight()/2);
            }else{
                GameVariables.currentPlayer.getFirstAbility().setX(GameVariables.currentPlayer.getX() - GameVariables.currentPlayer.getWidth() + 10);
                GameVariables.currentPlayer.getFirstAbility().setY(GameVariables.currentPlayer.getY() + GameVariables.currentPlayer.getHeight()/2);
            }


            this.drawAbility = true;

        }
   }


   public void changePLayers(){
       if (GameVariables.currentPlayer == GameVariables.player1) {
           GameVariables.currentPlayer = GameVariables.player2;
           GameVariables.opponentPlayer = GameVariables.player1;
       } else if (GameVariables.currentPlayer == GameVariables.player2) {
           GameVariables.currentPlayer = GameVariables.player1;
           GameVariables.opponentPlayer = GameVariables.player2;
       }
   }

}
