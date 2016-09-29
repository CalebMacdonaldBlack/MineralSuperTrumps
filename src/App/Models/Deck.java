package App.Models;

import App.Models.Card.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Deck {
    private final ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
    }

    public Card takeRandomCard(){
        if(cards.size() == 0){
            throw new NullPointerException("No cards left in deck");
        }
        int index = new Random().nextInt(cards.size());
        return cards.remove(index);
    }

    public int sizeOfDeck(){
        return cards.size();
    }
}
