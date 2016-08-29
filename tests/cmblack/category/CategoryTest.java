package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class CategoryTest {

    @Test
    public void testGetName() throws Exception {
        assertEquals("Hardness", new Category("Hardness") {
            @Override
            public boolean isBetterThan(Category category) {
                return false;
            }
        }.getName());
    }
}