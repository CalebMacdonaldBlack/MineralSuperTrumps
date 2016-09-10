package cmblack.card;

import cmblack.card.stats.IStats;
import cmblack.card.trumpcard.TrumpCardStats;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CategoryComparisonResultTest {
    CategoryComparisonResult categoryComparisonResult = new IStats.FakePlayCardStats().compareWith(new IStats.FakePlayCardStats2());

    @Test
    public void testCleavage() throws Exception {
        assertEquals(-6, categoryComparisonResult.cleavage());
    }

    @Test
    public void testCrustalAbundance() throws Exception {
        assertEquals(2, categoryComparisonResult.crustalAbundance());
    }

    @Test
    public void testEconomicValue() throws Exception {
        assertEquals(2, categoryComparisonResult.economicValue());
    }

    @Test
    public void testHardness() throws Exception {
        assertEquals(-0.4, categoryComparisonResult.hardness(), 0);
    }

    @Test
    public void testSpecificGravity() throws Exception {
        assertEquals(-0.7, categoryComparisonResult.specificGravity(), 0);
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(categoryComparisonResult.equals(categoryComparisonResult));
        assertFalse(categoryComparisonResult.equals(new TrumpCardStats().compareWith(new IStats.FakePlayCardStats())));
    }

    @Test
    public void testValueForCategory() throws Exception {

    }
}