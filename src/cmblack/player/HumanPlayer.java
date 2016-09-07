package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.deck.Deck;
import cmblack.game.Round;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 26/08/2016.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(String playerName, ArrayList<Card> cards) {
        super(playerName, cards);
    }

    public Card getCardToPlay(String selectedCategory, Card currentCard, Deck deck) {
        throw new NotImplementedException();
    }

    public String chooseCategory() {
        throw new NotImplementedException();
    }

    public String chooseCategory(String[] categories) {
        throw new NotImplementedException();
    }

    @Override
    public void haveTurn(Round round) {
        throw new NotImplementedException();
    }

    @Override
    public void removeCard(Card card, Round round) {
        throw new NotImplementedException();
    }

    public HumanPlayer(String playerName) {
        this(playerName, new ArrayList<Card>());
    }
}
