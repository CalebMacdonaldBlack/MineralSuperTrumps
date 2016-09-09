package cmblack.deck;

import cmblack.card.ICard;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IDeck {
    ArrayList<ICard> getCards();
    ICard takeCard();

    class FakeDeck implements IDeck {

        @Override
        public ArrayList<ICard> getCards() {
            return null;
        }

        @Override
        public ICard takeCard() {
            return null;
        }
    }
}
