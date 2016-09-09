package cmblack.category.economicvalue;

import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class EconomicValueTest {

    IEconomicValue economicValue = new EconomicValue(EconomicValueValue.TRIVIAL);

    @Test
    public void testGetValue() throws Exception {
        assertEquals(EconomicValueValue.TRIVIAL, economicValue.getValue());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(economicValue.equals(new EconomicValue(EconomicValueValue.TRIVIAL)));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(economicValue.getCategory().equals(new Category("Economic getValue")));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}