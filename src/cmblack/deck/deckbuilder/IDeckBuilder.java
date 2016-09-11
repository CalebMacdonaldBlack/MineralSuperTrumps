package cmblack.deck.deckbuilder;

import cmblack.deck.IDeck;

import java.io.FileNotFoundException;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public interface IDeckBuilder {
    IDeck build() throws FileNotFoundException;

    class FakeDeckBuilder implements IDeckBuilder {

        @Override
        public IDeck build() throws FileNotFoundException {
            return new IDeck.FakeDeck();
        }
    }
}
