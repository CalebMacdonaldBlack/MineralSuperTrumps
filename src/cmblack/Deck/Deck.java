package cmblack.deck;

import cmblack.card.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class Deck {
    private final ArrayList<Card> cards;

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card takeCard(){
        return cards.remove(0);
    }

    public Deck shuffle(){
        Collections.shuffle(cards);
        return this;
    }
}
