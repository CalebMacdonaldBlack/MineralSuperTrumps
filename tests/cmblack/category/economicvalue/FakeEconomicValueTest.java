package cmblack.category.economicvalue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeEconomicValueTest {

    IEconomicValue economicValue = new IEconomicValue.FakeGoodEconomicValue();

    @Test
    public void testGetValue() throws Exception {
        assertEquals(EconomicValueValue.HIGH, economicValue.getValue());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(economicValue.equals(new IEconomicValue.FakeGoodEconomicValue()));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(economicValue.getCategory().equals(new IEconomicValue.FakeGoodEconomicValue().getCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}