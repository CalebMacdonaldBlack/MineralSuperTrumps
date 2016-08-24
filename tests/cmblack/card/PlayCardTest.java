package cmblack.card;

import cmblack.category.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCardTest {

    @Test
    public void testGetChemicalCompound() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        assertEquals("Al(O H)3", new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getChemicalCompound());
    }

    @Test
    public void testGetClassification() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        assertEquals("hydroxide", new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getClassification());
    }

    @Test
    public void testGetCrystalSystem() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        assertEquals("orthorhombic", new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getCrystalSystem());
    }

    @Test
    public void testGetOccurrences() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};
        assertEquals(occurrences, new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getOccurrences());
    }

    @Test
    public void testGetPlayCardStats() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        assertEquals(playCardStats, new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getPlayCardStats());
    }


    @Test
    public void testGetTitle() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        assertEquals("Title", new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getTitle());
    }

    @Test
    public void testGetSubTitle() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        assertEquals("SubTitle", new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getSubTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        assertEquals("Filename.txt", new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats).getImageFilename());
    }
}