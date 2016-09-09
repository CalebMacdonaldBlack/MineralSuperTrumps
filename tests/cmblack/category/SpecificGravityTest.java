package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class SpecificGravityTest {

    ISpecificGravity specificGravity = new SpecificGravity(1.2, 1.8);

    @Test
    public void testGetMinimumValue() throws Exception {
        assertEquals(1.2, specificGravity.getMinimumValue(), .001);
    }

    @Test
    public void testGetMaximumValue() throws Exception {
        assertEquals(1.8, specificGravity.getMaximumValue(), .001);
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(specificGravity.getCategory().equals(new Category("Specific gravity")));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(specificGravity.equals(new SpecificGravity(1.2, 1.8)));
        assertFalse(specificGravity.equals(new SpecificGravity(1.2, 2.1)));
    }
}