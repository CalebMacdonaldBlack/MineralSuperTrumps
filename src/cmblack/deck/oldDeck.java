package cmblack.deck;

import cmblack.card.ICard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class oldDeck {
    private final ArrayList<ICard> cards;
    private final ArrayList<ICard> discardedCards;

    public oldDeck(ArrayList<ICard> cards, ArrayList<ICard> discardedCards) {
        this.cards = cards;
        this.discardedCards = discardedCards;
    }

    public ArrayList<ICard> getCards() {
        return cards;
    }

    public ICard takeCard(){
        if(cards.size() < 1){
            System.out.println("Adding discarded to deck");
            addDiscardedPileToDeck();
        }
        return cards.remove(0);
    }

    private void addDiscardedPileToDeck() {
        ArrayList<ICard> cardsToMove = new ArrayList<>(discardedCards);
        for(ICard card: cardsToMove){
            this.cards.add(card);
            this.discardedCards.remove(card);
        }
    }

    public oldDeck shuffle(){
        Collections.shuffle(cards);
        return this;
    }

    public ArrayList<ICard> getDiscardedCards() {
        return discardedCards;
    }

    public oldDeck addToDiscardedPile(ICard card){
        this.discardedCards.add(card);
        return this;
    }
}
