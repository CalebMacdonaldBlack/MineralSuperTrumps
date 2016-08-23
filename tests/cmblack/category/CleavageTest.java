package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class CleavageTest {

    @Test
    public void testGetValue() throws Exception {
        Cleavage.CleavageOptions value = Cleavage.CleavageOptions.GOOD1;
        assertEquals(value, new Cleavage(value).getValue());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Cleavage", new Cleavage(Cleavage.CleavageOptions.GOOD1).getName());
    }

    @Test
    public void testGetName1() throws Exception {
        assertEquals("clvg", new Cleavage("clvg", Cleavage.CleavageOptions.GOOD1).getName());
    }
}