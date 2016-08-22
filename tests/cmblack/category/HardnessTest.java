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
}