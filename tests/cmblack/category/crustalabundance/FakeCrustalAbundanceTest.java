package cmblack.category.crustalabundance;

import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeCrustalAbundanceTest {

    ICrustalAbundance crustalAbundance = new ICrustalAbundance.FakeCrustalAbundance();

    @Test
    public void testGetValue() throws Exception {
        assertEquals(CrustalAbundanceValue.HIGH, crustalAbundance.getValue());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(crustalAbundance.equals(new ICrustalAbundance.FakeCrustalAbundance()));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(crustalAbundance.getCategory().equals(new Category("Crustal abundance")));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}