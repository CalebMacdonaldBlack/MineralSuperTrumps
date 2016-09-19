package cmblack.deck;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class ShuffledDeck implements IDeck{

    private final IDeck deck;

    public ShuffledDeck(IDeck deck){
        this.deck = deck;
    }

    @Override
    public ICard takeCard() {
        if(length() > 0){
            return deck.takeCardAt(new Random().nextInt(deck.length()));
        } else {
            return new EmptyCard();
        }
    }

    @Override
    public ICard takeCardAt(int index) {
        return deck.takeCardAt(index);
    }

    @Override
    public int length() {
        return deck.length();
    }
}
