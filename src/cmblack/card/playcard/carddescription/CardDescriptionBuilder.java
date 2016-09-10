package cmblack.card.playcard.carddescription;

import cmblack.card.CardDescription;
import cmblack.deck.deckbuilder.IParsedCard;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CardDescriptionBuilder implements ICardDescriptionBuilder {
    @Override
    public ICardDescription build(IParsedCard parsedCard) {
        return new CardDescription(
                parsedCard.getChemistry(),
                parsedCard.getClassification(),
                parsedCard.getCrystal_system(),
                parsedCard.getOccurrence()
        );
    }
}
