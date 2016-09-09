package cmblack.category.economicvalue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class EconomicValueEnumTest {

    @Test
    public void testGetEconomicValue() throws Exception {
        assertTrue(EconomicValueEnum.HIGH.getEconomicValue().equals(new EconomicValue(3, "high")));
    }

    @Test
    public void testFindWithValueName() throws Exception {
        assertTrue(EconomicValueEnum.HIGH.getEconomicValue().equals(EconomicValueEnum.findWithValueName("high").getEconomicValue()));
    }
}