package cmblack.card.playcard;

import cmblack.category.CategoryComparisonResult;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CategoryComparisonResultTest {

    CategoryComparisonResult categoryComparisonResult = new CategoryComparisonResult(1, 2, -2, 1.2, 1.4);

    @Test
    public void testCleavage() throws Exception {
        assertEquals(1, categoryComparisonResult.cleavage());
    }

    @Test
    public void testCrustalAbundance() throws Exception {
        assertEquals(2, categoryComparisonResult.crustalAbundance());
    }

    @Test
    public void testEconomicValue() throws Exception {
        assertEquals(-2, categoryComparisonResult.economicValue());
    }

    @Test
    public void testHardness() throws Exception {
        assertEquals(1.2, categoryComparisonResult.hardness(), .001);
    }

    @Test
    public void testSpecificGravity() throws Exception {
        assertEquals(1.4, categoryComparisonResult.specificGravity(), .001);
    }
}