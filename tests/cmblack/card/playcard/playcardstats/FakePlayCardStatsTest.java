package cmblack.card.playcard.playcardstats;

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
public class FakePlayCardStatsTest {

    IPlayCardStats playCardStats = new IPlayCardStats.FakePlayCardStats();

    @Test
    public void testGetCrustalAbundance() throws Exception {
        assertTrue(playCardStats.getCrustalAbundance().equals(new ICrustalAbundance.FakeCrustalAbundance()));
    }

    @Test
    public void testGetHardness() throws Exception {
        assertTrue(playCardStats.getHardness().equals(new IHardness.FakeHardness()));
    }

    @Test
    public void testGetEconomicValue() throws Exception {
        assertTrue(playCardStats.getEconomicValue().equals(new IEconomicValue.FakeEconomicValue()));
    }

    @Test
    public void testGetSpecificGravity() throws Exception {
        assertTrue(playCardStats.getSpecificGravity().equals(new ISpecificGravity.FakeSpecificGravity()));
    }

    @Test
    public void testGetCleavage() throws Exception {
        assertTrue(playCardStats.getCleavage().equals(new ICleavage.FakeCleavage()));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(playCardStats.equals(new IPlayCardStats.FakePlayCardStats()));
    }
}