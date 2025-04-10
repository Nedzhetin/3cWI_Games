package at.nejo.StrategyGame;

import at.nejo.StrategyGame.Abilities.*;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class GameVariables {

    public static Image backgroundImg;
    public static Image frozenImg;
    public static AngelCodeFont font;
    public static AngelCodeFont font2;


    public static Character player1 = null;
    public static Character player2 = null;
    public static Character currentPlayer = null;
    public static Character opponentPlayer = null;

    public static boolean gameOver = false;


    public static FireBallAbility fireBallAbility = new FireBallAbility(10, "testdata/fireBallAbilityImg.png", true);
    public static HealAbility healAbility = new HealAbility(-20, "testdata/healAbilityImg.png", false);
    public static SnowBallAbility snowBallAbility = new SnowBallAbility(5, "testdata/snowBallAbilityImg.png", true);
    public static SoilWallAbility soilWallAbility = new SoilWallAbility(0, "testdata/soilWallAbilityImg.png", true, 20);
    public static WaterWaveAbility waterWaveAbility = new WaterWaveAbility(15, "testdata/waterWaveImg.png", true);
    public static GiantRockAbility giantRockAbility = new GiantRockAbility(20, "testdata/giantRockAbilityImg.png", true);
    public static LightningStrike lightningStrike = new LightningStrike(25, "testdata/lightningStrikeImg.png", true, 0);
    public static LightningBolt lightningBolt = new LightningBolt(30, "testdata/lightningBoltImg.png", true, 0);


    public static final Character fireMan = new Character("Pablo", 100, Character.TYPE.FIRE, "testdata/fireCharacterImg.png", 30, 720, fireBallAbility, healAbility);
    public static final Character iceMan = new Character("Cryo", 100, Character.TYPE.ICE, "testdata/waterCharacterImg.png", 530, 720, snowBallAbility, waterWaveAbility);
    public static final Character earthMan = new Character("Onix", 120, Character.TYPE.EARTH, "testdata/earthManImg.png", 1030, 720, soilWallAbility, giantRockAbility);
    public static final Character lightingMan = new Character("Cid", 80, Character.TYPE.LIGHTNING, "testdata/lightingCharacterImg.png", 1530, 720, lightningStrike, lightningBolt);



    public static List<Content> contents = new ArrayList<Content>();


    static {

        contents.add(fireMan);
        contents.add(iceMan);
        contents.add(earthMan);
        contents.add(lightingMan);


        try {
            backgroundImg = new Image("testdata/backgroundImg_strategyGame.jpg");
            font = new AngelCodeFont("testdata/hiero.fnt", "testdata/hiero.png");
            font2 = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
            frozenImg = new Image("testdata/frozenImg.png");
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean isColliding(float x, float y, Content b) {

        return x < b.getX() + b.getWidth() &&
                x > b.getX() &&
                y < b.getY() + b.getHeight() &&
                y > b.getY();
    }


    public static boolean isCollidingAbilityCharacter(Ability a, Character b) {

        if (a instanceof LightningStrike) {
            return a.getY() > b.getY() + b.getHeight() + 200;


        } else {
            return a.getX() < b.getX() + b.getWidth() / 2 &&
                    a.getX() + a.getWidth() / 2 > b.getX() &&
                    a.getY() < b.getY() + b.getHeight() &&
                    a.getY() + a.getHeight() + 300 > b.getY();
        }
    }

    public static boolean isCollidingAbilityAbility(Ability a, Ability b) {

        return a.getX() < b.getX() + b.getWidth() / 2.4 &&
                a.getX() > b.getX() &&
                a.getY() < b.getY() + b.getHeight() &&
                a.getY() + a.getHeight() > b.getY();
    }

    public static void checkGameOver() {
        if (player1.getHealth() <= 0) {
            System.out.println("Player 2 wins!");
            gameOver = true;
        } else if (player2.getHealth() <= 0) {
            System.out.println("Player 1 wins!");
            gameOver = true;
        }
    }

    public static void resetGame() {
        player1 = fireMan;
        player2 = iceMan;
        currentPlayer = player1;
        opponentPlayer = player2;
        contents.clear();
        contents.add(fireMan);
        contents.add(iceMan);
        contents.add(earthMan);
        contents.add(lightingMan);
        gameOver = false; // Reset the gameOver flag
    }
}
