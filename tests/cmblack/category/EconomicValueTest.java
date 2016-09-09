package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class EconomicValueTest {

    IEconomicValue economicValue = new EconomicValue(1, "trivial");

    @Test
    public void testGetValue() throws Exception {
        assertEquals(1, economicValue.getValue());
    }

    @Test
    public void testGetValueName() throws Exception {
        assertEquals("trivial", economicValue.getValueName());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(economicValue.equals(new EconomicValue(1, "trivial")));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(economicValue.getCategory().equals(new Category("Economic value")));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}