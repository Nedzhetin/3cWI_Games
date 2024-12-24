package at.nejo.StrategyGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
    public static final int CHARACTER_SELECTION = 0;
    public static final int GAME_SCENE = 1;

    public Main(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new CharacterSelectionScene(CHARACTER_SELECTION));
        this.addState(new GameScene(GAME_SCENE));
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Strategy Game"));
            container.setDisplayMode(2000, 1500, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
