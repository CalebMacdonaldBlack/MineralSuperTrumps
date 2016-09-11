package cmblack.category.hardness;

import cmblack.category.Category;
import cmblack.category.ICategory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class HardnessTest {

    IHardness hardness = new Hardness(1.2, 1.7);

    @Test
    public void testGetMinimumValue() throws Exception {
        assertEquals(1.2, hardness.getMinimumValue(), .001);
    }

    @Test
    public void testGetMaximumValue() throws Exception {
        assertEquals(1.7, hardness.getMaximumValue(), .001);
    }

    @Test
    public void testGetCategory() throws Exception {
        assertTrue(hardness.getCategory().equals(new ICategory.FakeHardnessCategory()));
    }

    @Test
    public void testIsBetterThan() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(hardness.equals(new Hardness(1.2, 1.7)));
        assertFalse(hardness.equals(new Hardness(1.2, 1.9)));
    }
}