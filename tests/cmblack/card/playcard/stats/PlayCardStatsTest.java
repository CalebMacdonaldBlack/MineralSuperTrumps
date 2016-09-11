package cmblack.card.playcard.stats;

import cmblack.card.stats.IStats;
import cmblack.card.stats.Stats;
import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class PlayCardStatsTest {

    IStats playCardStats = new Stats(
        new ICleavage.FakeCleavage(),
        new ICrustalAbundance.FakeGoodCrustalAbundance(),
        new IEconomicValue.FakeGoodEconomicValue(),
        new IHardness.FakeHardness(),
        new ISpecificGravity.FakeSpecificGravity()
    );

    @Test
    public void testGetCleavage() throws Exception {
        assertTrue(playCardStats.getCleavage().equals(new ICleavage.FakeCleavage()));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(playCardStats.getCrustalAbundance().equals(new ICrustalAbundance.FakeGoodCrustalAbundance()));
    }

    @Test
    public void testGetCrustalAbundance() throws Exception {
        assertTrue(playCardStats.getCrustalAbundance().equals(new ICrustalAbundance.FakeGoodCrustalAbundance()));
    }

    @Test
    public void testGetEconomicValue() throws Exception {
        assertTrue(playCardStats.getEconomicValue().equals(new IEconomicValue.FakeGoodEconomicValue()));
    }

    @Test
    public void testGetHardness() throws Exception {
        assertTrue(playCardStats.getHardness().equals(new IHardness.FakeHardness()));
    }

    @Test
    public void testGetSpecificGravity() throws Exception {
        assertTrue(playCardStats.getSpecificGravity().equals(new ISpecificGravity.FakeSpecificGravity()));
    }
}