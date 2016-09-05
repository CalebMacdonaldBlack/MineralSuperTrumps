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

        Round round = new Round(players, deck);

        while(round.getWinningPlayer() == null){
            round.begin();
        }

    }
}
