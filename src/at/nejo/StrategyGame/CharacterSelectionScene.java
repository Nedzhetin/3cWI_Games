package at.nejo.StrategyGame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.HashMap;
import java.util.Map;

public class CharacterSelectionScene extends BasicGameState {
    private final int stateId;






    private Image arrowImg;
    private boolean drawArrowImg = false;
    Map<String, Float> arrowPosition = new HashMap<>();


    private GameVariables gameVariables;

    public CharacterSelectionScene(int stateId) {
        this.stateId = stateId;
    }


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        GameVariables.backgroundImg = GameVariables.backgroundImg.getScaledCopy(2000,1500);


        arrowImg = new Image("testdata/arrowImg.png");
        arrowImg = arrowImg.getScaledCopy(100,100);

        arrowPosition.put("x", 0f);
        arrowPosition.put("y", 0f);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        GameVariables.backgroundImg.draw();

        for (Content content  : GameVariables.contents) {
            content.draw();

            if (drawArrowImg) {
                arrowImg.draw(arrowPosition.get("x"), arrowPosition.get("y"));

            }
        }

        if (GameVariables.player1 == null){
            GameVariables.font.drawString(700,650,"Player 1 choose your Character");
        }else if(GameVariables.player2 == null) {
            GameVariables.font.drawString(700,650,"Player 2 choose your Character");
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (GameVariables.player1 != null && GameVariables.player2 != null) {
            stateBasedGame.enterState(Main.GAME_SCENE);
            GameVariables.player1.setBig(true);
            GameVariables.player2.setBig(true);

        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        for (Content content : GameVariables.contents) {
            if(content instanceof Character) {
                if(GameVariables.isColliding(x,y,content)) {
                    if (GameVariables.player1 == null){
                        GameVariables.player1 = (Character) content;
                        GameVariables.currentPlayer = GameVariables.player1;
                    }else {
                        GameVariables.player2 = (Character) content;
                        System.out.println(GameVariables.player2.getName());
                    }

                    System.out.println(GameVariables.player1.getName());

                }
            }
        }
    }


    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);

        for (Content content : GameVariables.contents) {
            if(content instanceof Character) {
                if (GameVariables.isColliding(oldx,oldy,content)) {
                    arrowPosition.put("x",content.getX() + 100);
                    arrowPosition.put("y",content.getY() - 100);
                    drawArrowImg = true;
                    break;
                }else {
                    drawArrowImg = false;

                }
            }
        }

    }


    @Override
    public int getID() {
        return stateId;
    }


}
