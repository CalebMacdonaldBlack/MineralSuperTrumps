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
    public ArrayList<ICard> getCards() {
        return null;
    }

    @Override
    public ICard takeCard() {
        return null;
    }
}
