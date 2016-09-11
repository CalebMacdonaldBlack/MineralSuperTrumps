package cmblack.category.specificgravity;

import cmblack.range.Range;
import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class SpecificGravityCategoryTest {

    @Test
    public void testGetCategoryName() throws Exception {
        assertEquals("Specific gravity", new SpecificGravityCategory().getCategoryName());
    }

    @Test
    public void testGetValueRange() throws Exception {
        assertTrue(new SpecificGravityCategory().getValueRange().equals(new Range(2.2, 7.6)));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new SpecificGravityCategory().equals(new Category("Specific gravity", new Range(2.2, 7.6))));
        assertFalse(new SpecificGravityCategory().equals(new Category("Specific grav", new Range(2.2, 7.6))));
        assertFalse(new SpecificGravityCategory().equals(new Category("Specific gravity", new Range(2.2, 7))));
    }
}