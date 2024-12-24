package at.nejo.StrategyGame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterSelectionScene extends BasicGameState {
    private int stateId;
    private Character player1 = null;
    private Character player2 = null;


    private Character fireMan;
    private Character iceMan;
    private Character earthMan;
    private Character lightingMan;
    private Character windMan;
    private Character waterMan;

    private List<Content> contents;

    private AngelCodeFont font;

    private Image arrowImg;
    private Image backgroundImg;
    private boolean drawArrowImg = false;

    Map<String, Float> arrowPosition = new HashMap<>();


    public CharacterSelectionScene(int stateId) {
        this.stateId = stateId;
    }


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        contents = new ArrayList<Content>();
        backgroundImg = new Image("testdata/backgroundImg_strategyGame.jpg");
        backgroundImg = backgroundImg.getScaledCopy(2000,1500);

        fireMan = new Character("Pablo",100, Character.TYPE.FIRE,"testdata/fireCharacterImg.png",50,1100);
        iceMan = new Character("Cryo",120, Character.TYPE.ICE,"testdata/iceCharacterImg.png",350,1100);
        earthMan = new Character("Muhammand",150,Character.TYPE.EARTH,"testdata/earthManImg.png",650,1100);
        lightingMan = new Character("Cid",80,Character.TYPE.LIGHTING,"testdata/lightingCharacterImg.png",950,1100);
        waterMan = new Character("Muhammad",90,Character.TYPE.WATER,"testdata/waterCharacterImg.png",1250,1100);
        windMan = new Character("Mehmet",110,Character.TYPE.WIND,"testdata/windCharacterImg.png",1550,1100);

        arrowImg = new Image("testdata/arrowImg.png");
        arrowImg = arrowImg.getScaledCopy(100,100);

        arrowPosition.put("x", 0f);
        arrowPosition.put("y", 0f);

        font = new AngelCodeFont("testdata/hiero.fnt","testdata/hiero.png");


        contents.add(fireMan);
        contents.add(iceMan);
        contents.add(earthMan);
        contents.add(lightingMan);
        contents.add(waterMan);
        contents.add(windMan);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        backgroundImg.draw();

        for (Content content : contents) {
            content.draw();

            if (drawArrowImg) {
                arrowImg.draw(arrowPosition.get("x"), arrowPosition.get("y"));

            }
        }

        if (player1 == null){
            font.drawString(700,650,"Player 1 choose your Character");
        }else if(player2 == null) {
            font.drawString(700,650,"Player 2 choose your Character");
        }else{
            font.drawString(100,100, "Player 1: " + player1.getName());
            font.drawString(gameContainer.getWidth() - 500,100, "Player 2: " + player2.getName());
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (player1 != null && player2 != null) {
            stateBasedGame.enterState(Main.GAME_SCENE);
        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        for (Content content : contents) {
            if(content instanceof Character) {
                if(isColliding(x,y,content)) {
                    if (player1 == null){
                        player1 = (Character) content;
                    }else {
                        player2 = (Character) content;
                    }

                    System.out.println(player1.getName());
                }
            }
        }
    }


    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);

        for (Content content : contents) {
            if(content instanceof Character) {
                if (isColliding(oldx,oldy,content)) {
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


    private boolean isColliding(int x, int y, Content b) {

        return x < b.getX() + b.getWidth() &&
                x  > b.getX() &&
                y < b.getY() + b.getHeight() &&
                y > b.getY();
    }
}
