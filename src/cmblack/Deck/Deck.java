package cmblack.deck;

import cmblack.player.Player;
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
        if(cards.size() < 1){
            System.out.println("Adding discarded to deck");
            addDiscardedPileToDeck();
        }
        return cards.remove(0);
    }

    private void addDiscardedPileToDeck() {
        ArrayList<Card> cardsToMove = new ArrayList<>(discardedCards);
        for(Card card: cardsToMove){
            this.cards.add(card);
            this.discardedCards.remove(card);
        }
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

    public Deck distributeToPlayers(int amountToDistribute, Player[] players){
        for(Player player: players){
            for(int count = 0; count < amountToDistribute; count++){
                player.giveCard(takeCard());
            }
        }
        return this;
    }
}
