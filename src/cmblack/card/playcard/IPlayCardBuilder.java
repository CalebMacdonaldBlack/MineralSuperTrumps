package cmblack.card.playcard;

import cmblack.deck.deckbuilder.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IPlayCardBuilder {
    //TODO remove dependency
    IPlayCard build(IParsedCard parsedCard);

    class FakePlayCardBuilder implements IPlayCardBuilder{

        @Override
        public IPlayCard build(IParsedCard parsedCard) {
            return new IPlayCard.FakePlayCard1();
        }
    }
}
