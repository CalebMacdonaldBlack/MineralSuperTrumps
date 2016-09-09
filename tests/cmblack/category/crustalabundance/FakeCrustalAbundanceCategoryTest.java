package cmblack.category.crustalabundance;

import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeCrustalAbundanceCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        ICategory category = new ICategory.FakeCrustalAbundanceCategory();
        assertEquals("Crustal abundance", category.getCategoryName());
    }

    @Test
    public void testEquals() throws Exception {
        ICategory category = new ICategory.FakeCrustalAbundanceCategory();
        ICategory category2 = new ICategory.FakeCrustalAbundanceCategory();
        assertTrue(category.equals(category2));
    }
}