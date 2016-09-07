package cmblack.game;

import cmblack.card.Card;
import cmblack.category.Category;
import cmblack.deck.Deck;
import cmblack.player.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 26/08/2016.
 */
public class Game {
    private final Player[] players;
    ArrayList<Player> playersStillIn = new ArrayList<>();
    private final Deck deck;
    private int playerTurn = 0;
    private Card currentCard;
    private Category currentCategory;

    private final int NUMBER_OF_CARDS_TO_START_WITH = 8;

    public Game(Player[] players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public void start(){
        deck.shuffle();
        deck.distributeToPlayers(NUMBER_OF_CARDS_TO_START_WITH, players);
        ArrayList<Player> winningPlayers = new ArrayList<>();

        for(Player player: players){
            playersStillIn.add(player);
        }

        while(playersStillIn.size() > 1){
            System.out.println("================");
            System.out.println("Starting New Round");
            System.out.println("================");
            Round round = new Round(deck, new PlayerCircle(playersStillIn.toArray(new Player[playersStillIn.size()])), winningPlayers);
            round.begin();
            System.out.println(round.getPlayerCircle().getRoundWinningPlayer().getPlayerName() + " Won the round");
            for(Player player: round.getWinningPlayers()){
                this.playersStillIn.remove(player);
            }
        }
        System.out.println("================");
        System.out.println("GAME FINISHED");
        System.out.println("================\n\n");


    }
}
