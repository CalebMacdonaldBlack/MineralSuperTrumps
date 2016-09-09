package cmblack.deck;

import cmblack.card.ICard;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IDeck {
    ICard takeCard();
    ICard takeCardAt(int index);
    int length();

    class FakeDeck implements IDeck {

        @Override
        public ICard takeCard() {
            return null;
        }

        @Override
        public ICard takeCardAt(int index) {
            return null;
        }

        @Override
        public int length() {
            return 0;
        }
    }
}
