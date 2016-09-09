package cmblack.deck;

import cmblack.card.ICard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class ShuffledDeck implements IDeck{

    private final ArrayList<ICard> cards;

    public ShuffledDeck(IDeck deck){
        this.cards = deck.getCards();
        Collections.shuffle(this.cards);
    }

    @Override
    public ArrayList<ICard> getCards() {
        return null;
    }

    @Override
    public ICard takeCard() {
        return null;
    }
}
