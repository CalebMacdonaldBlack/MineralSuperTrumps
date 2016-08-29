package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class HardnessTest {

    @Test
    public void testGetRangeLow() throws Exception {
        assertEquals(1.3, new Hardness(1.3, 1.7).getRangeLow(), 0.1);

    }

    @Test
    public void testGetRangeHigh() throws Exception {
        assertEquals(1.7, new Hardness(1.3, 1.7).getRangeHigh(), 0.1);
    }

    @Test
    public void testGetName() {
        assertEquals("Hardness", new Hardness(1.3, 1.7).getName());
    }

    @Test
    public void testGetName1() {
        assertEquals("My Hardness", new Hardness("My Hardness", 1.3, 1.7).getName());
    }

    @Test
    public void testIsBetterThan() throws Exception {
        Hardness hardness1 = new Hardness(1,2);
        Hardness hardness2 = new Hardness(2,3);
        assertTrue(hardness2.isBetterThan(hardness1));
    }

    public void testIsBetterThan1() throws Exception {
        Hardness hardness1 = new Hardness(1,2);
        Hardness hardness2 = new Hardness(2,3);
        assertFalse(hardness1.isBetterThan(hardness2));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIsBetterThan2() throws Exception {
        Cleavage cleavage1 = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        Hardness hardness = new Hardness(1, 2);
        hardness.isBetterThan(cleavage1);
    }
}