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
}