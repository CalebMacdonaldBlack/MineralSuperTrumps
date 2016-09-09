package cmblack.card.playcard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CategoryComparisonResultTest {

    CategoryComparisonResult categoryComparisonResult = new CategoryComparisonResult(true, true, true, true, true);

    @Test
    public void testCleavage() throws Exception {
        assertEquals(true, categoryComparisonResult.cleavage());
    }

    @Test
    public void testCrustalAbundance() throws Exception {
        assertEquals(true, categoryComparisonResult.crustalAbundance());
    }

    @Test
    public void testEconomicValue() throws Exception {
        assertEquals(true, categoryComparisonResult.economicValue());
    }

    @Test
    public void testHardness() throws Exception {
        assertEquals(true, categoryComparisonResult.hardness());
    }

    @Test
    public void testSpecificGravity() throws Exception {
        assertEquals(true, categoryComparisonResult.specificGravity());
    }
}