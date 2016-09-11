package cmblack.category.cleavage;

import cmblack.range.Range;
import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class CleavageCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        assertEquals("Cleavage", new CleavageCategory().getCategoryName());
    }

    @Test
    public void testGetValueRange() throws Exception {
        assertTrue(new Range(1, 15).equals(new CleavageCategory().getValueRange()));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new CleavageCategory().equals(new Category("Cleavage", new Range(1, 15))));
    }
}