package cmblack.category.economicvalue;

import cmblack.Range;
import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class EconomicValueCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        assertEquals("Economic value", new EconomicValueCategory().getCategoryName());
    }

    @Test
    public void testGetValueRange() throws Exception {
        assertTrue(new Range(1, 7).equals(new EconomicValueCategory().getValueRange()));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new EconomicValueCategory().equals(new Category("Economic value", new Range(1, 7))));
        assertFalse(new EconomicValueCategory().equals(new Category("Economic value", new Range(1, 5))));
        assertFalse(new EconomicValueCategory().equals(new Category("Economic val", new Range(1, 7))));
    }
}