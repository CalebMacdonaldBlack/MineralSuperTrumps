package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.deck.Deck;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 26/08/2016.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, ArrayList<Card> cards) {
        super(playerName, cards);
    }

    @Override
    public Card getCardToPlay(String selectedCategory, Card currentCard, Deck deck) {
        throw new NotImplementedException();
    }

    @Override
    public String chooseCategory() {
        throw new NotImplementedException();
    }

    @Override
    public String chooseCategory(String[] categories) {
        throw new NotImplementedException();
    }

    public HumanPlayer(String playerName) {
        this(playerName, new ArrayList<Card>());
    }
}
