package cmblack.category;

import cmblack.range.Range;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        ICategory category = new Category("Hardness", new Range(1, 10));
        assertEquals("Hardness", category.getCategoryName());
    }

    @Test
    public void testEquals() throws Exception {
        ICategory category = new Category("Hardness", new Range(1, 10));
        ICategory category2 = new Category("Hardness", new Range(1, 10));
        ICategory category3 = new Category("Cleavage", new Range(1, 10));
        assertTrue(category.equals(category2));
        assertFalse(category2.equals(category3));
    }

    @Test
    public void testValueRange() throws Exception {
        ICategory category = new Category("Hardness", new Range(1, 10));
        assertTrue(new Range(1, 10).equals(category.getValueRange()));
    }
}