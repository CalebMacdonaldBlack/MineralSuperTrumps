package App;

import App.Controllers.GameController;
import App.Models.Deck;
import App.Models.Player;
import App.Models.RoundResult;
import App.Models.StaticDeckBuilder;
import App.Views.Game.GameView;
import App.Views.Game.GameViewGui;
import App.Views.Game.IGameView;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Game implements GameController {
    private final ArrayList<Player> players;
    private final Deck deck;
    private final IGameView gameView;

    /**
     * Creates a new instance of a game
     * @param players The players in the game
     */
    public Game(ArrayList<Player> players) {
        this.players = players;
//        this.gameView = new GameView();
        this.gameView = new GameViewGui();
        deck = new StaticDeckBuilder().buildDeck();
    }

    /**
     * Begins a new game
     */
    public void begin() {
        // Starts the game up
        gameView.gameStarted();
        distributeCardsToPlayers();
        Player startingPlayer = players.get(new Random().nextInt(players.size()));
        ArrayList<Player> playersInGame = getNewArrayList(players);
        ArrayList<Player> winners = new ArrayList<>();
        RoundResult roundResult = new RoundResult(startingPlayer, null, RoundResult.RoundResultType.START);

        // Loops over the rounds in a game
        while(playersInGame.size() > 1){
            // Begin round
            roundResult = new Round(getNewArrayList(playersInGame), deck).begin(roundResult);

            //check to see if player won
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

    /**
     * Copies an arraylist without reference
     * @param players The arraylist to copy
     * @return An arraylist at a different reference
     */
    private ArrayList<Player> getNewArrayList(ArrayList<Player> players) {
        return players.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * distributes cards to each player
     */
    private void distributeCardsToPlayers() {
        for(Player player: players){
            for(int count=0; count<8;count++){
                player.getCards().add(deck.takeRandomCard());
            }
        }

    }
}
