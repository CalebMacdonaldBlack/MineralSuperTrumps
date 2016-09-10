package cmblack.category.crustalabundance;

import cmblack.deck.IParsedCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CrustalAbundanceBuilderTest {

    ICrustalAbundanceBuilder cleavageBuilder = new CrustalAbundanceBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard();

    @Test
    public void testBuild() throws Exception {
        ICrustalAbundance crustalAbundance = cleavageBuilder.build(parsedCard.getCrustal_abundance());
        assertEquals("low", crustalAbundance.getValue().getText());
    }

    @Test
    public void testBuild1() throws Exception {
        ICrustalAbundance crustalAbundance = cleavageBuilder.build(parsedCard.getCrustal_abundance(), "crustAbund");
        assertEquals("crustAbund", crustalAbundance.getCategory().getCategoryName());
    }
}