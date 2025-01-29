package at.nejo.StrategyGame;

import at.nejo.StrategyGame.Abilities.Ability;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameScene extends BasicGameState {

    private int stateId;
    private boolean useFirstAbility;
    private boolean useSecondAbility;


    public GameScene(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public int getID() {
        return stateId;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.useFirstAbility = false;
        this.useSecondAbility = false;

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        GameVariables.backgroundImg.draw();
        GameVariables.drawAbilityBtns(graphics);


        if (this.useFirstAbility) {
            handleAbility(GameVariables.currentPlayer.getFirstAbility());

        }

        if (this.useSecondAbility) {
            handleAbility(GameVariables.currentPlayer.getSecondAbility());

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

            this.useFirstAbility = true;

        }
        if (key == Input.KEY_2){
            this.useSecondAbility = true;
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

   public void handleAbility(Ability ability){
       if (ability.isDrawAbility()) {
           ability.draw();

           if (GameVariables.currentPlayer == GameVariables.player2){
               ability.setAbilityImg(ability.getAbilityImg().getFlippedCopy(true,false));

           }
           ability.move();

           if (GameVariables.isCollidingAbilityCharacter(GameVariables.currentPlayer.getFirstAbility(),GameVariables.opponentPlayer)){
               GameVariables.currentPlayer.getFirstAbility().ActivateAbility(GameVariables.currentPlayer,GameVariables.opponentPlayer);
               changePLayers();
               this.useFirstAbility = false;
           }
       }else {
               GameVariables.currentPlayer.getSecondAbility().ActivateAbility(GameVariables.currentPlayer,GameVariables.opponentPlayer);
               changePLayers();
               this.useSecondAbility = false;
       }

   }

}
