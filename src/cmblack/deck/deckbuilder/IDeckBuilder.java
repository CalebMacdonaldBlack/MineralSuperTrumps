package cmblack.deck.deckbuilder;

import cmblack.deck.IDeck;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public interface IDeckBuilder {
    IDeck build();

    class FakeDeckBuilder implements IDeckBuilder {

        @Override
        public IDeck build() {
            return new IDeck.FakeDeck();
        }
    }
}
