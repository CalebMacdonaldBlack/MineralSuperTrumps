package cmblack.card;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeCardDescriptionTest {

    @Test
    public void testGetChemicalCompound() throws Exception {
        ICardDescription cardDescription = new ICardDescription.FakeCardDescription();
        assertEquals("Au", cardDescription.getChemicalCompound());
    }

    @Test
    public void testGetClassification() throws Exception {
        ICardDescription cardDescription = new ICardDescription.FakeCardDescription();
        assertEquals("Native Element", cardDescription.getClassification());
    }

    @Test
    public void testGetCrystalSystem() throws Exception {
        ICardDescription cardDescription = new ICardDescription.FakeCardDescription();
        assertEquals("isometric", cardDescription.getCrystalSystem());
    }

    @Test
    public void testGetOccurrences() throws Exception {
        ICardDescription cardDescription = new ICardDescription.FakeCardDescription();
        assertEquals("metamorphic", cardDescription.getOccurrences()[0]);
        assertEquals("sedimentry", cardDescription.getOccurrences()[1]);
    }
}