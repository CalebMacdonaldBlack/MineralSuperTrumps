package App;

import App.Controllers.GameController;
import App.Models.Deck;
import App.Models.Player;
import App.Models.StaticDeckBuilder;
import App.Views.GameView;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Game implements GameController {
    private final ArrayList<Player> players;
    private final Deck deck;
    private final GameView gameView;

    public Game(ArrayList<Player> players) {
        this.players = players;
        this.gameView = new GameView();
        deck = new StaticDeckBuilder().buildDeck();
    }

    public void begin() {
        gameView.gameStarted();
    }
}
