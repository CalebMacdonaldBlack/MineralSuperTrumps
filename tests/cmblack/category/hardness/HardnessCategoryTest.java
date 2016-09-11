package cmblack.category.hardness;

import cmblack.Range;
import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class HardnessCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        assertEquals("Hardness", new HardnessCategory().getCategoryName());
    }

    @Test
    public void testGetValueRange() throws Exception {
        assertTrue(new HardnessCategory().getValueRange().equals(new Range(1, 10)));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new HardnessCategory().equals(new Category("Hardness", new Range(1, 10))));
        assertFalse(new HardnessCategory().equals(new Category("Hard", new Range(1, 10))));
        assertFalse(new HardnessCategory().equals(new Category("Hardness", new Range(1, 9))));
    }
}