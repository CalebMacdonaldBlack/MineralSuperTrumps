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
        distributeCardsToPlayers();
        System.out.println(players.get(0).getCards().size());
    }

    private void distributeCardsToPlayers() {
        for(Player player: players){
            for(int count=0; count<6;count++){
                player.getCards().add(deck.takeRandomCard());
            }
        }
    }
}
