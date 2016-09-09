package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        ICategory category = new Category("Hardness");
        assertEquals("Hardness", category.getCategoryName());
    }

    @Test
    public void testEquals() throws Exception {
        ICategory category = new Category("Hardness");
        ICategory category2 = new Category("Hardness");
        ICategory category3 = new Category("Cleavage");
        assertTrue(category.equals(category2));
        assertFalse(category2.equals(category3));
    }
}