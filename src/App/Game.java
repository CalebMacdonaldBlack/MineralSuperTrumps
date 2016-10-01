package App;

import App.Controllers.GameController;
import App.Models.Deck;
import App.Models.Player;
import App.Models.StaticDeckBuilder;
import App.Views.GameView;

import java.util.ArrayList;
import java.util.Random;

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
        Player startingPlayer = players.get(new Random().nextInt(players.size()));
        ArrayList<Player> playersInGame = getNewArrayList(players);
        ArrayList<Player> winners = new ArrayList<>();
        while(playersInGame.size() > 1){
            startingPlayer = new Round(getNewArrayList(playersInGame), deck).begin(startingPlayer);
            for (Player player: playersInGame.toArray(new Player[playersInGame.size()])){
                if(player.getCards().size() == 0){
                    playersInGame.remove(player);
                    winners.add(player);
                    gameView.winner(player);
                }
            }
        }
        gameView.listWinners(winners);
    }

    private ArrayList<Player> getNewArrayList(ArrayList<Player> players) {
        ArrayList<Player> newList = new ArrayList<>();
        for(int i=0;i<players.size();i++){
            newList.add(players.get(i));
        }
        return newList;
    }

    private void distributeCardsToPlayers() {
        for(Player player: players){
            for(int count=0; count<8;count++){
                player.getCards().add(deck.takeRandomCard());
            }
        }

    }
}
