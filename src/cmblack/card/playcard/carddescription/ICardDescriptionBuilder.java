package cmblack.card.playcard.carddescription;

import cmblack.deck.IParsedCard;
import cmblack.deck.ParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ICardDescriptionBuilder {
    ICardDescription build(IParsedCard parsedCard);

    class FakeCardDescriptionBuilder implements ICardDescriptionBuilder {

        @Override
        public ICardDescription build(IParsedCard parsedCard) {
            return new ICardDescription.FakeCardDescription();
        }
    }
}
