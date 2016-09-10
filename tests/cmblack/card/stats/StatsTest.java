package cmblack.card.stats;

import cmblack.card.CategoryComparisonResult;
import cmblack.card.trumpcard.TrumpCardStats;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class StatsTest {

    IStats stats = new Stats(
            new ICleavage.FakeCleavage(),
            new ICrustalAbundance.FakeCrustalAbundance(),
            new IEconomicValue.FakeEconomicValue(),
            new IHardness.FakeHardness(),
            new ISpecificGravity.FakeSpecificGravity());

    @Test
    public void testGetCleavage() throws Exception {
        assertTrue(stats.getCleavage().equals(new ICleavage.FakeCleavage()));
    }

    @Test
    public void testGetCrustalAbundance() throws Exception {
        assertTrue(stats.getCrustalAbundance().equals(new ICrustalAbundance.FakeCrustalAbundance()));
    }

    @Test
    public void testGetEconomicValue() throws Exception {
        assertTrue(stats.getEconomicValue().equals(new IEconomicValue.FakeEconomicValue()));
    }

    @Test
    public void testGetHardness() throws Exception {
        assertTrue(stats.getHardness().equals(new IHardness.FakeHardness()));
    }

    @Test
    public void testGetSpecificGravity() throws Exception {
        assertTrue(stats.getSpecificGravity().equals(new ISpecificGravity.FakeSpecificGravity()));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(stats.equals(new Stats(
                new ICleavage.FakeCleavage(),
                new ICrustalAbundance.FakeCrustalAbundance(),
                new IEconomicValue.FakeEconomicValue(),
                new IHardness.FakeHardness(),
                new ISpecificGravity.FakeSpecificGravity())));
        assertFalse(stats.equals(new TrumpCardStats()));
    }

    @Test
    public void testCompareWith1() throws Exception {
        CategoryComparisonResult categoryComparisonResult = stats.compareWith(stats);
        assertEquals(0, categoryComparisonResult.cleavage());
        assertEquals(0, categoryComparisonResult.specificGravity(), .001);
        assertEquals(0, categoryComparisonResult.hardness(), .001);
        assertEquals(0, categoryComparisonResult.crustalAbundance());
        assertEquals(0, categoryComparisonResult.economicValue());
    }

    @Test
    public void testCompareWith() throws Exception {
        CategoryComparisonResult categoryComparisonResult = stats.compareWith(new IStats.FakePlayCardStats2());
        assertEquals(-6, categoryComparisonResult.cleavage());
        assertEquals(-0.7, categoryComparisonResult.specificGravity(), 0.1);
        assertEquals(-0.4, categoryComparisonResult.hardness(), .001);
        assertEquals(2, categoryComparisonResult.crustalAbundance());
        assertEquals(2, categoryComparisonResult.economicValue());
    }
}