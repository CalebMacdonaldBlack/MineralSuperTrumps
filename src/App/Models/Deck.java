package App.Models;

import App.Models.Card.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    /**
     * Adds a card to the deck
     *
     * @param card The card to add
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Takes a random card from the deck
     *
     * @return Randomly selected card
     */
    public Card takeRandomCard() {
        if (cards.size() == 0) {
            throw new NullPointerException("No cards left in deck");
        }
        int index = new Random().nextInt(cards.size());
        return cards.remove(index);
    }

    /**
     * Gets the size of the deck
     *
     * @return
     */
    public int sizeOfDeck() {
        return cards.size();
    }
}
