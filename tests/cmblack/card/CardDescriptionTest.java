package cmblack.card;

import cmblack.card.playcard.carddescription.CardDescription;
import cmblack.card.playcard.carddescription.ICardDescription;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CardDescriptionTest {

    ICardDescription cardDescription = new CardDescription(
            "Au",
            "Native element",
            "isometric",
            new String[]{
                    "Metamorphic",
                    "sedimentry"
            }
    );

    @Test
    public void testGetChemicalCompound() throws Exception {
        assertEquals("Au", cardDescription.getChemicalCompound());
    }

    @Test
    public void testGetClassification() throws Exception {
        assertEquals("Native element", cardDescription.getClassification());
    }

    @Test
    public void testGetCrystalSystem() throws Exception {
        assertEquals("isometric", cardDescription.getCrystalSystem());
    }

    @Test
    public void testGetOccurrences() throws Exception {
        assertTrue(Arrays.equals(
                new String[]{
                        "Metamorphic",
                        "sedimentry"
                },
                cardDescription.getOccurrences()
        ));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(cardDescription.equals(cardDescription));
        assertFalse(cardDescription.equals(new ICardDescription.FakeCardDescription()));
    }
}