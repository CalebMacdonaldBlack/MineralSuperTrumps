package cmblack.category.cleavage;

import cmblack.category.Category;
import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CleavageTest {

    private ICleavage cleavage = new Cleavage(CleavageValue.GOOD1);

    @Test
    public void testEquals() throws Exception {
        assertTrue(cleavage.equals(new Cleavage(CleavageValue.GOOD1)));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(cleavage.getCategory().equals(new ICategory.FakeCleavageCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }

    @Test
    public void testValue() throws Exception {
        assertEquals(CleavageValue.GOOD1, cleavage.getValue());
    }
}