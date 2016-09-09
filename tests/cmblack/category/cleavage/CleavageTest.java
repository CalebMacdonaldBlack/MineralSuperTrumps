package cmblack.category.cleavage;

import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CleavageTest {

    private ICleavage cleavage = new Cleavage(2, "none");

    @Test
    public void testGetValue() throws Exception {
        assertEquals(2, cleavage.getValue());
    }

    @Test
    public void testGetValueName() throws Exception {
        assertEquals("none", cleavage.getValueName());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(cleavage.equals(new Cleavage(2, "none")));
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(cleavage.getCategory().equals(new Category("Cleavage")));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }
}