package cmblack.category.specificgravity;

import cmblack.deck.IParsedCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class SpecificGravityBuilderTest {

    ISpecificGravityBuilder specificGravityBuilder = new SpecificGravityBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard();

    @Test
    public void testBuild() throws Exception {
        ISpecificGravity specificGravity = specificGravityBuilder.build(parsedCard.getSpecific_gravity());
        assertEquals(5, specificGravity.getMinimumValue(), 0);
        assertEquals(5.5, specificGravity.getMaximumValue(), 0);
    }

    @Test
    public void testBuild1() throws Exception {
        ISpecificGravity specificGravity = specificGravityBuilder.build(parsedCard.getSpecific_gravity(), "specGrav");
        assertEquals("specGrav", specificGravity.getCategory().getCategoryName());
    }
}