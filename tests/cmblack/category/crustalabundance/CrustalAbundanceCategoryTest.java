package cmblack.category.crustalabundance;

import cmblack.range.Range;
import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class CrustalAbundanceCategoryTest {

    @Test
    public void testEquals() throws Exception {
        assertTrue(new CrustalAbundanceCategory().equals(new Category("Crustal abundance", new Range(1, 7))));
        assertFalse(new CrustalAbundanceCategory().equals(new Category("Crustal abundance", new Range(1, 3))));
        assertFalse(new CrustalAbundanceCategory().equals(new Category("Crustal abundan", new Range(1, 7))));
    }

    @Test
    public void testGetCategoryName() throws Exception {
        assertEquals("Crustal abundance", new CrustalAbundanceCategory().getCategoryName());
    }

    @Test
    public void testGetValueRange() throws Exception {
        assertTrue(new Range(1, 7).equals(new CrustalAbundanceCategory().getValueRange()));
    }
}