package cmblack.card;

import cmblack.card.stats.IStats;
import cmblack.card.trumpcard.TrumpCardStats;
import cmblack.category.Category;
import cmblack.category.ICategory;
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
        assertEquals(-2.4, categoryComparisonResult.hardness(), 0);
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
        assertEquals(-6, categoryComparisonResult.valueForCategory(new ICategory.FakeCleavageCategory()), 0);
        assertEquals(2, categoryComparisonResult.valueForCategory(new ICategory.FakeCrustalAbundanceCategory()), 0);
        assertEquals(2, categoryComparisonResult.valueForCategory(new ICategory.FakeEconomicValueCategory()), 0);
        assertEquals(-2.4, categoryComparisonResult.valueForCategory(new ICategory.FakeHardnessCategory()), 0);
        assertEquals(-0.7, categoryComparisonResult.valueForCategory(new ICategory.FakeSpecificGravityCategory()), 0);
    }
}