package cmblack.deck;

import cmblack.card.Card;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class Deck {
    private final Card[] cards;

    public Deck(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }
}
