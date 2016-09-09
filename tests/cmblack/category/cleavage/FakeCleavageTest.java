package cmblack.category.cleavage;

import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeCleavageTest {

    ICleavage cleavage = new ICleavage.FakeCleavage();

    @Test
    public void testGetValue() throws Exception {
        assertEquals(CleavageValue.GOOD2, cleavage.getValue());
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(new ICategory.FakeCleavageCategory().equals(cleavage.getCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(cleavage.equals(new ICleavage.FakeCleavage()));
    }
}