package cmblack.card.trumpcard;

import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.deck.deckbuilder.IParsedCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class TrumpCardBuilderTest {

    ITrumpCardBuilder trumpCardBuilder = new TrumpCardBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard2();

    @Test
    public void testBuild() throws Exception {
        ITrumpCard trumpCard = trumpCardBuilder.build(parsedCard);
        assertEquals("The Geophysist", trumpCard.getTitle());
        assertEquals("Changed the trump category to Specific gravity", trumpCard.getSubTitle());
        assertTrue(trumpCard.changeableTrumpCategories()[0].equals(new ICategory.FakeSpecificGravityCategory()));
        assertEquals("slide59.jpg", trumpCard.getImageFilename());
    }
}