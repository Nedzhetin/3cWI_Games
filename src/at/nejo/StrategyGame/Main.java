package at.nejo.StrategyGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends BasicGame {
    private Character player1;
    private Character player2;

    private Character fireMan;
    private Character iceMan;
    private Character earthMan;
    private Character lightingMan;
    private Character windMan;

    private List<Content> content;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        content = new ArrayList<Content>();
        fireMan = new Character("Pablo",100, Character.TYPE.FIRE,"testdata/fireCharacterImg.png",0,1000);
        iceMan = new Character("Cryo",120, Character.TYPE.ICE,"testdata/iceCharacterImg.png",400,1000);
        earthMan = new Character("Muhammand",150,Character.TYPE.EARTH,"testdata/earthManImg.png",800,1000);
        lightingMan = new Character("Cid",80,Character.TYPE.LIGHTING,"testdata/lightingCharacterImg.png",1200,1000);


        content.add(fireMan);
        content.add(iceMan);
        content.add(earthMan);
        content.add(lightingMan);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        for (Content content : content) {
            content.draw();
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new at.nejo.StrategyGame.Main("StrategyGame"));
            container.setDisplayMode(2000, 1500, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
