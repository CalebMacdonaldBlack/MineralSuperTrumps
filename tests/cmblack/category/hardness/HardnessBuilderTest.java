package cmblack.category.hardness;

import cmblack.deck.deckbuilder.IParsedCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class HardnessBuilderTest {

    IHardnessBuilder hardnessBuilder = new HardnessBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard();

    @Test
    public void testBuild() throws Exception {
        IHardness hardness = hardnessBuilder.build(parsedCard.getHardness());
        assertEquals(5, hardness.getMinimumValue(), 0);
        assertEquals(5.5, hardness.getMaximumValue(), 0);
    }

    @Test
    public void testBuild1() throws Exception {
        IHardness hardness = hardnessBuilder.build(parsedCard.getHardness(), "hard");
        assertEquals("hard", hardness.getCategory().getCategoryName());
    }
}