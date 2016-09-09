package cmblack.category.hardness;

import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeHardnessCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        ICategory category = new ICategory.FakeHardnessCategory();
        assertEquals("Hardness", category.getCategoryName());
    }

    @Test
    public void testEquals() throws Exception {
        ICategory category = new ICategory.FakeHardnessCategory();
        ICategory category2 = new ICategory.FakeHardnessCategory();
        ICategory category3 = new ICategory.FakeCategory2();
        assertTrue(category.equals(category2));
        assertFalse(category.equals(category3));
    }
}