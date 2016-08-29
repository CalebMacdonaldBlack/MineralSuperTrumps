package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.category.Category;
import cmblack.deck.Deck;
import cmblack.player.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 26/08/2016.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, ArrayList<Card> cards) {
        super(playerName, cards);
    }

    @Override
    public void haveTurn(String selectedCategory, PlayCard currentCard, Deck deck, ArrayList<Player> playersInCurrentTurn) {

    }

    public HumanPlayer(String playerName) {
        this(playerName, new ArrayList<Card>());
    }
}
