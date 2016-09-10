package cmblack.card.playcard.carddescription;

import cmblack.deck.IParsedCard;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CardDescriptionBuilderTest {

    ICardDescriptionBuilder cardDescriptionBuilder = new CardDescriptionBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard();

    @Test
    public void testBuild() throws Exception {
        ICardDescription cardDescription = cardDescriptionBuilder.build(parsedCard);
        assertEquals("Au", cardDescription.getChemicalCompound());
        assertEquals("native element", cardDescription.getClassification());
        assertEquals("isometric", cardDescription.getCrystalSystem());
        assertTrue(Arrays.equals(
                cardDescription.getOccurrences(),
                new String[]{
                        "metamorphic",
                        "sedimentary"
                }
        ));
    }
}