package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeSpecificGravityTest {

    ISpecificGravity specificGravity = new ISpecificGravity.FakeSpecificGravity();

    @Test
    public void testGetMinimumValue() throws Exception {
        assertEquals(2.3, specificGravity.getMinimumValue(), .001);
    }

    @Test
    public void testGetMaximumValue() throws Exception {
        assertEquals(2.7, specificGravity.getMaximumValue(), .001);
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(specificGravity.getCategory().equals(new ICategory.FakeSpecificGravityCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(specificGravity.equals(new SpecificGravity(2.3, 2.7)));
        assertFalse(specificGravity.equals(new SpecificGravity(2.8, 2.7)));
    }
}