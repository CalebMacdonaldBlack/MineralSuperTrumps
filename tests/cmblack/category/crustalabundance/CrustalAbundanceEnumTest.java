package cmblack.category.crustalabundance;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CrustalAbundanceEnumTest {

    @Test
    public void testGetCrustalAbundance() throws Exception {
        assertTrue(CrustalAbundanceEnum.HIGH.getCrustalAbundance().equals(new CrustalAbundance(4, "high")));
    }

    @Test
    public void testFindWithValueName() throws Exception {
        assertTrue(CrustalAbundanceEnum.HIGH.getCrustalAbundance().equals(CrustalAbundanceEnum.findWithValueName("high").getCrustalAbundance()));
    }
}