package cmblack.card;

import cmblack.category.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCardStatsTest {

    @Test
    public void testGetCleavage() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);

        assertEquals(cleavage, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getCleavage());
    }

    @Test
    public void testGetCrustalAbundance() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);

        assertEquals(crustalAbundance, new PlayCardStats(cleavage,crustalAbundance, economicValue, hardness, specificGravity).getCrustalAbundance());
    }

    @Test
    public void testGetEconomicValue() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);

        assertEquals(economicValue, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getEconomicValue());
    }

    @Test
    public void testGetHardness() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);

        assertEquals(hardness, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getHardness());
    }

    @Test
    public void testGetSpecificGravity() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);

        assertEquals(specificGravity, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getSpecificGravity());
    }

    @Test
    public void testGetCategoryWithLabel() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);

        assertEquals(hardness, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getCategoryWithName("Hardness"));
        assertEquals(specificGravity, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getCategoryWithName("Specific gravity"));
        assertEquals(economicValue, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getCategoryWithName("Economic value"));
        assertEquals(crustalAbundance, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getCategoryWithName("Crustal abundance"));
        assertEquals(cleavage, new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity).getCategoryWithName("Cleavage"));
    }
}