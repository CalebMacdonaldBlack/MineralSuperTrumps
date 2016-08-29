package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class SpecificGravityTest {

    @Test
    public void testGetRangeLow() throws Exception {
        assertEquals(1.2, new SpecificGravity(1.2, 1.5).getRangeLow(), .1);
    }

    @Test
    public void testGetRangeHigh() throws Exception {
        assertEquals(1.5, new SpecificGravity(1.2, 1.5).getRangeHigh(), .1);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("SpecificGravity", new SpecificGravity("SpecificGravity", 1.2, 1.5).getName());
    }

    @Test
    public void testIsBetterThan() throws Exception {
        SpecificGravity specificGravity1 = new SpecificGravity(1,2);
        SpecificGravity specificGravity2 = new SpecificGravity(2,3);
        assertTrue(specificGravity2.isBetterThan(specificGravity1));
    }
    @Test
    public void testIsBetterThan1() throws Exception {
        SpecificGravity specificGravity1 = new SpecificGravity(1,2);
        SpecificGravity specificGravity2 = new SpecificGravity(2,3);
        assertFalse(specificGravity1.isBetterThan(specificGravity2));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIsBetterThan2() throws Exception {
        CrustalAbundance crustalAbundance1 = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        SpecificGravity specificGravity = new SpecificGravity(1, 2);
        specificGravity.isBetterThan(crustalAbundance1);
    }
}