package cmblack.category.cleavage;

import cmblack.deck.deckbuilder.IParsedCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CleavageBuilderTest {

    ICleavageBuilder cleavageBuilder = new CleavageBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard();

    @Test
    public void testBuild() throws Exception {
        ICleavage cleavage = cleavageBuilder.build(parsedCard.getCleavage());
        assertEquals("3 good", cleavage.getValue().getText());
    }

    @Test
    public void testBuild1() throws Exception {
        ICleavage cleavage = cleavageBuilder.build(parsedCard.getCleavage(), "cleav");
        assertEquals("cleav", cleavage.getCategory().getCategoryName());
    }
}