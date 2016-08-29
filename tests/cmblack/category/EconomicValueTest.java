package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class EconomicValueTest {

    @Test
    public void testGetValue() throws Exception {
        EconomicValue.EconomicValueOptions value = EconomicValue.EconomicValueOptions.HIGH;
        assertEquals(value, new EconomicValue(value).getValue());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Economic value", new EconomicValue(EconomicValue.EconomicValueOptions.HIGH).getName());
    }

    @Test
    public void testGetName1() throws Exception {
        assertEquals("eco val", new EconomicValue("eco val" ,EconomicValue.EconomicValueOptions.HIGH).getName());
    }
}