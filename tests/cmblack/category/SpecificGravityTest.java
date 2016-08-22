package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class SpecificGravityTest {

    @Test
    public void testGetRangeLow() throws Exception {
        assertEquals(1.2, new SpecificGravity(1.2, 1.5).getRangeLow());
    }

    @Test
    public void testGetRangeHigh() throws Exception {
        assertEquals(1.5, new SpecificGravity(1.2, 1.5).getRangeHigh());
    }
}