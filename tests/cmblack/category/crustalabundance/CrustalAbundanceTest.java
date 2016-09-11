package cmblack.category.crustalabundance;

import cmblack.category.Category;
import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CrustalAbundanceTest {

    ICrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundanceValue.HIGH);

    @Test
    public void testGetValue() throws Exception {
        assertEquals(CrustalAbundanceValue.HIGH, crustalAbundance.getValue());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(crustalAbundance.equals(new CrustalAbundance(CrustalAbundanceValue.HIGH)));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(new ICategory.FakeCrustalAbundanceCategory().equals(crustalAbundance.getCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}