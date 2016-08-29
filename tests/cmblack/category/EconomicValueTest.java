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

    @Test
    public void testIsBetterThan() throws Exception {
        EconomicValue economicValue1 = new EconomicValue(EconomicValue.EconomicValueOptions.HIGH);
        EconomicValue economicValue2 = new EconomicValue(EconomicValue.EconomicValueOptions.LOW);
        assertTrue(economicValue1.isBetterThan(economicValue2));
    }

    @Test
    public void testIsBetterThan1() throws Exception {
        EconomicValue economicValue1 = new EconomicValue(EconomicValue.EconomicValueOptions.HIGH);
        EconomicValue economicValue2 = new EconomicValue(EconomicValue.EconomicValueOptions.LOW);
        assertFalse(economicValue2.isBetterThan(economicValue1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIsBetterThan2() throws Exception {
        EconomicValue economicValue1 = new EconomicValue(EconomicValue.EconomicValueOptions.HIGH);
        Hardness hardness = new Hardness(1, 2);
        economicValue1.isBetterThan(hardness);
    }
}