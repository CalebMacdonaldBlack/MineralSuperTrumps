package cmblack.card;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class PlayCardTest {

    @Test
    public void testGetChemicalCompound() throws Exception {
        assertEquals("Al(O H)3", new PlayCard("","","","Al(O H)3","","",null).getChemicalCompound());
    }

    @Test
    public void testGetClassification() throws Exception {
        assertEquals("hydroxide", new PlayCard("","","","","hydroxide","",null).getClassification());
    }

    @Test
    public void testGetCrystalSystem() throws Exception {
        assertEquals("orthorhombic", new PlayCard("","","","","","orthorhombic",null).getCrystalSystem());
    }

    @Test
    public void testGetOccurrences() throws Exception {
        String[] occurrences = new String[]{"sedementry", "surface"};
        assertEquals(occurrences, new PlayCard("","","","Al(O H)3","","",occurrences).getOccurrences());
    }
}