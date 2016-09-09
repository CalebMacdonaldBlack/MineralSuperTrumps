package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        ICategory category = new ICategory.FakeCategory();
        assertEquals("Hardness", category.getCategoryName());
    }

    @Test
    public void testEquals() throws Exception {
        ICategory category = new ICategory.FakeCategory();
        ICategory category2 = new ICategory.FakeCategory();
        ICategory category3 = new ICategory.FakeCategory2();
        assertTrue(category.equals(category2));
        assertFalse(category.equals(category3));
    }
}