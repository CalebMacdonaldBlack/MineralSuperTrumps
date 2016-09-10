package cmblack.card.stats;

import cmblack.deck.deckbuilder.IParsedCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class StatsBuilderTest {

    IStatsBuilder statsBuilder = new StatsBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard();

    @Test
    public void testBuild() throws Exception {
        IStats stats = statsBuilder.build(parsedCard);
        assertEquals("low", stats.getCrustalAbundance().getValue().getText());
        assertEquals("low", stats.getEconomicValue().getValue().getText());
        assertEquals("3 good", stats.getCleavage().getValue().getText());
        assertEquals(5, stats.getHardness().getMinimumValue(), 0);
        assertEquals(5.5, stats.getHardness().getMaximumValue(), 0);
        assertEquals(5, stats.getSpecificGravity().getMinimumValue(), 0);
        assertEquals(5.5, stats.getHardness().getMaximumValue(), 0);
    }
}