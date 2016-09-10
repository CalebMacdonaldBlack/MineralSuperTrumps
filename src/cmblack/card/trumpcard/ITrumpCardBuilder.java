package cmblack.card.trumpcard;

import cmblack.deck.deckbuilder.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ITrumpCardBuilder {
    ITrumpCard build(IParsedCard parsedCard);

    class FakeTrumpCardBuilder implements ITrumpCardBuilder {

        @Override
        public ITrumpCard build(IParsedCard parsedCard) {
            return new ITrumpCard.FakeTrumpCard();
        }
    }
}
