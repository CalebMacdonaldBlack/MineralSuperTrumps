package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class CategoryValueRangeTest {

    @Test
    public void testGetLow() throws Exception {
        assertEquals(2.1, new CategoryValueRange(2.1, 3.4).getLow(), 0.1);
    }

    @Test
    public void testGetHigh() throws Exception {
        assertEquals(3.4, new CategoryValueRange(2.1, 3.4).getHigh(), 0.1);
    }
}