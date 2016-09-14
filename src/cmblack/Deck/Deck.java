package cmblack.deck;

import cmblack.card.ICard;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class Deck implements IDeck {

    private final ArrayList<ICard> cards;

    public Deck(ArrayList<ICard> cards) {
        this.cards = cards;
    }

    @Override
    public ICard takeCard() {
        ICard card = cards.get(0);
        cards.remove(card);
        return card;
    }

    @Override
    public ICard takeCardAt(int index) {
        ICard card = cards.get(index);
        cards.remove(card);
        return card;
    }

    @Override
    public int length() {
        return cards.size();
    }
}
