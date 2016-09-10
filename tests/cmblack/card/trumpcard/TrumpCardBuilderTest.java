package cmblack.card.trumpcard;

import cmblack.category.Category;
import cmblack.deck.IParsedCard;
import org.junit.Test;

import java.util.Arrays;

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
        assertTrue(trumpCard.getCategories()[0].equals(new Category("Specific gravity")));
        assertEquals("slide59.jpg", trumpCard.getImageFilename());
    }
}