package cmblack.category;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class CrustalAbundanceTest {

    @Test
    public void testGetValue() throws Exception {
        CrustalAbundance.CrustalAbundanceValue value = CrustalAbundance.CrustalAbundanceValue.HIGH;
        assertEquals(value, new CrustalAbundance(value).getValue());
    }

    @Test
    public void testGetValue1() throws Exception {
        CrustalAbundance.CrustalAbundanceValue value = CrustalAbundance.CrustalAbundanceValue.HIGH;
        assertEquals("Crustal-Abundance", new CrustalAbundance("Crustal-Abundance", value).getName());
    }

    @Test
    public void testGetValue2() throws Exception {
        CrustalAbundance.CrustalAbundanceValue value = CrustalAbundance.CrustalAbundanceValue.HIGH;
        assertEquals(value, new CrustalAbundance("Crustal-Abundance", value).getValue());
    }
}