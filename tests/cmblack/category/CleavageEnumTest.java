package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CleavageEnumTest {

    @Test
    public void testGetCleavage() throws Exception {
        Cleavage cleavage = new Cleavage(0, "none");
        assertTrue(CleavageEnum.NONE.getCleavage().equals(cleavage));
    }

    @Test
    public void testEquals() throws Exception {
        Cleavage cleavage = new Cleavage(0, "none");
        assertTrue(CleavageEnum.NONE.equals(cleavage));
    }
}