package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeEconomicValueTest {

    IEconomicValue economicValue = new IEconomicValue.FakeEconomicValue();

    @Test
    public void testGetValue() throws Exception {
        assertEquals(2, economicValue.getValue());
    }

    @Test
    public void testGetValueName() throws Exception {
        assertEquals("moderate", economicValue.getValueName());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(economicValue.equals(new IEconomicValue.FakeEconomicValue()));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(economicValue.getCategory().equals(new IEconomicValue.FakeEconomicValue().getCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}