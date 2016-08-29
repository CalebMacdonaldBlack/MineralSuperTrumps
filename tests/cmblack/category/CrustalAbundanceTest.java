package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class CrustalAbundanceTest {

    @Test
    public void testGetValue() throws Exception {
        CrustalAbundance.CrustalAbundanceOptions value = CrustalAbundance.CrustalAbundanceOptions.HIGH;
        assertEquals(value, new CrustalAbundance(value).getValue());
    }

    @Test
    public void testGetValue1() throws Exception {
        CrustalAbundance.CrustalAbundanceOptions value = CrustalAbundance.CrustalAbundanceOptions.HIGH;
        assertEquals("Crustal-Abundance", new CrustalAbundance("Crustal-Abundance", value).getName());
    }

    @Test
    public void testGetValue2() throws Exception {
        CrustalAbundance.CrustalAbundanceOptions value = CrustalAbundance.CrustalAbundanceOptions.HIGH;
        assertEquals(value, new CrustalAbundance("Crustal-Abundance", value).getValue());
    }

    @Test
    public void testIsBetterThan() throws Exception {
        CrustalAbundance crustalAbundance1 = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        CrustalAbundance crustalAbundance2 = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.LOW);
        assertTrue(crustalAbundance1.isBetterThan(crustalAbundance2));
    }

    @Test
    public void testIsBetterThan1() throws Exception {
        CrustalAbundance crustalAbundance1 = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        CrustalAbundance crustalAbundance2 = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.LOW);
        assertFalse(crustalAbundance2.isBetterThan(crustalAbundance1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIsBetterThan2() throws Exception {
        CrustalAbundance crustalAbundance1 = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Hardness hardness = new Hardness(1, 2);
        crustalAbundance1.isBetterThan(hardness);
    }
}