package cmblack.deck;

import cmblack.card.Card;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class Deck {
    private final ArrayList<Card> cards;
    private final ArrayList<Card> discardedCards;

    public Deck(ArrayList<Card> cards, ArrayList<Card> discardedCards) {
        this.cards = cards;
        this.discardedCards = discardedCards;
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

    public ArrayList<Card> getDiscardedCards() {
        return discardedCards;
    }

    public Deck addToDiscardedPile(Card card){
        this.discardedCards.add(card);
        return this;
    }
}
