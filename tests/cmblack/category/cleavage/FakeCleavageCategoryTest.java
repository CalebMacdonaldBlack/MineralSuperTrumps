package cmblack.category.cleavage;

import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeCleavageCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        ICategory category = new ICategory.FakeCleavageCategory();
        assertEquals("Cleavage", category.getCategoryName());
    }

    @Test
    public void testEquals() throws Exception {
        ICategory category = new ICategory.FakeCleavageCategory();
        ICategory category2 = new ICategory.FakeCleavageCategory();
        assertTrue(category.equals(category2));
    }
}