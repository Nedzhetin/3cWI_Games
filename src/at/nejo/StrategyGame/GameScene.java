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

    public GameScene(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        if (GameVariables.player1 != null && GameVariables.player2 != null) {
            Image newPlayer1Img = GameVariables.player1.getCharacterImg().getScaledCopy(600,600);
            GameVariables.player1.setCharacterImg(newPlayer1Img);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        GameVariables.backgroundImg.draw();

        GameVariables.player1.setXY(200,700);
        GameVariables.player1.draw();
        GameVariables.player1.drawHealthBar(graphics);

        GameVariables.player2.setXY(1500,700);
        GameVariables.player2.draw();
        GameVariables.player2.drawHealthBar(graphics);


        graphics.drawString("" + GameVariables.player1.getName(),100,100);
        graphics.drawString("" + GameVariables.player2.getName(),1300,100);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    public void mouseClicked(int button, int x, int y, int clickCount) {
        for (Content content : GameVariables.contents) {
            if(content instanceof Character) {
                if(GameVariables.isColliding(x,y,content)) {

                    ((Character) content).setHealth( ((Character) content).getHealth() - 10);
                    System.out.println(((Character) content).getHealth());
                }
            }
        }
    }

   public void keyPressed(int key, char c) {
        if (key == Input.KEY_1) {
            if (GameVariables.currentPlayer == GameVariables.player1) {
                GameVariables.player2.setHealth(GameVariables.player2.getHealth() - 10);
                GameVariables.currentPlayer = GameVariables.player2;
                System.out.println("sldkfj");
            }else {
                GameVariables.player1.setHealth(GameVariables.player1.getHealth() - 10);
                GameVariables.currentPlayer = GameVariables.player1;
            }
            System.out.println("1 was pressed");
        }
   }

}
