package cmblack.category.crustalabundance;

import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CrustalAbundanceTest {

    ICrustalAbundance crustalAbundance = new CrustalAbundance(4, "high");

    @Test
    public void testGetValue() throws Exception {
        assertEquals(4, crustalAbundance.getValue());
    }

    @Test
    public void testGetValueName() throws Exception {
        assertEquals("high", crustalAbundance.getValueName());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(crustalAbundance.equals(new CrustalAbundance(4, "high")));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(new Category("Crustal abundance").equals(crustalAbundance.getCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}