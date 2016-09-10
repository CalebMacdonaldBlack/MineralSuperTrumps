package cmblack.card.playcard;

import cmblack.deck.IParsedCard;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class PlayCardBuilderTest {

    IPlayCardBuilder playCardBuilder = new PlayCardBuilder();

    @Test
    public void testBuild() throws Exception {
        IPlayCard playCard = playCardBuilder.build(new IParsedCard.FakeParsedCard());
        assertEquals("Gold", playCard.getTitle());
        assertEquals("slide45.jpg", playCard.getImageFilename());
        assertEquals("isometric", playCard.getCardDescription().getCrystalSystem());
        assertEquals("Au", playCard.getCardDescription().getChemicalCompound());
        assertEquals("native element", playCard.getCardDescription().getClassification());
        assertTrue(Arrays.equals(playCard.getCardDescription().getOccurrences(), new String[]{"metamorphic", "sedimentary"}));
        assertEquals("3 good", playCard.getStats().getCleavage().getValue().getText());
        assertEquals("low", playCard.getStats().getEconomicValue().getValue().getText());
        assertEquals("low", playCard.getStats().getCleavage().getValue().getText());
        assertEquals(5.5, playCard.getStats().getHardness().getMaximumValue(), 0);
        assertEquals(5, playCard.getStats().getHardness().getMinimumValue(), 0);
        assertEquals(5.5, playCard.getStats().getSpecificGravity().getMaximumValue(), 0);
        assertEquals(5, playCard.getStats().getSpecificGravity().getMinimumValue(), 0);
    }
}