package cmblack.deck;

import cmblack.card.ICard;
import cmblack.deck.deckbuilder.IJsonReaderWrapper;
import cmblack.deck.deckbuilder.JSONDeckBuilder;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IDeck {
    ICard takeCard();
    ICard takeCardAt(int index);
    int length();

    class FakeDeck implements IDeck {

        ArrayList<ICard> cards = new ArrayList<>();

        public FakeDeck() throws FileNotFoundException {
            IDeck deck = new JSONDeckBuilder(new IJsonReaderWrapper.FakeJsonReaderWrapper().getReader()).build();
            for(int i=0;i<deck.length();i++){
                cards.add(deck.takeCard());
            }
        }

        @Override
        public ICard takeCard() {
            return cards.get(0);
        }

        @Override
        public ICard takeCardAt(int index) {
            return cards.get(index);
        }

        @Override
        public int length() {
            return cards.size();
        }
    }
}

