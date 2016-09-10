package cmblack.card.trumpcard;

import cmblack.card.stats.IStats;
import cmblack.category.cleavage.Cleavage;
import cmblack.category.cleavage.CleavageValue;
import cmblack.category.crustalabundance.CrustalAbundance;
import cmblack.category.crustalabundance.CrustalAbundanceValue;
import cmblack.category.economicvalue.EconomicValue;
import cmblack.category.economicvalue.EconomicValueValue;
import cmblack.category.hardness.Hardness;
import cmblack.category.specificgravity.SpecificGravity;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class TrumpCardStatsTest {

    TrumpCardStats trumpCardStats = new TrumpCardStats();

    @Test
    public void testGetCrustalAbundance() throws Exception {
        assertTrue(trumpCardStats.getCrustalAbundance().equals(new CrustalAbundance(CrustalAbundanceValue.TRUMPCARD)));
    }

    @Test
    public void testGetHardness() throws Exception {
        assertTrue(trumpCardStats.getHardness().equals(new Hardness(0,0)));
    }

    @Test
    public void testGetEconomicValue() throws Exception {
        assertTrue(trumpCardStats.getEconomicValue().equals(new EconomicValue(EconomicValueValue.TRUMPCARD)));
    }

    @Test
    public void testGetSpecificGravity() throws Exception {
        assertTrue(trumpCardStats.getSpecificGravity().equals(new SpecificGravity(0,0)));
    }

    @Test
    public void testGetCleavage() throws Exception {
        assertTrue(trumpCardStats.getCleavage().equals(new Cleavage(CleavageValue.TRUMPCARD)));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(trumpCardStats.equals(new TrumpCardStats()));
        assertFalse(trumpCardStats.equals(new IStats.FakePlayCardStats()));
    }
}