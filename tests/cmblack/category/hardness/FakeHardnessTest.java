package cmblack.category.hardness;

import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeHardnessTest {

    private IHardness hardness = new IHardness.FakeHardness();

    @Test
    public void testGetMinimumValue() throws Exception {
        assertEquals(1.2, hardness.getMinimumValue(), 0.001);
    }

    @Test
    public void testGetMaximumValue() throws Exception {
        assertEquals(1.7, hardness.getMaximumValue(), 0.001);
    }

    @Test
    public void testGetCategory() throws Exception {
        ICategory category = new ICategory.FakeHardnessCategory();
        assertTrue(hardness.getCategory().equals(category));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(hardness.equals(new IHardness.FakeHardness()));
    }
}