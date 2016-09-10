package cmblack.card.trumpcard;

import cmblack.card.playcard.CardType;
import cmblack.category.ICategory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class TrumpCardTest {

    ITrumpCard trumpCard = new TrumpCard(
            "Geophysisist",
            "Change the trump category to Specific gravity",
            "Slide59.jpg",
            new ICategory[]{new ICategory.FakeSpecificGravityCategory()}
            );

    @Test
    public void testGetCategories() throws Exception {
        assertTrue(this.areCategoryArraysEqual(
                trumpCard.getCategories(),
                new ICategory[]{new ICategory.FakeSpecificGravityCategory()}
        ));


    }

    private boolean areCategoryArraysEqual(ICategory[] a, ICategory[] a2){
        if (a==a2)
            return true;
        if (a==null || a2==null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        for (int i=0; i<length; i++)
            if (!a[i].equals(a2[i]))
                return false;

        return true;
    }

    @Test
    public void testGetSubTitle() throws Exception {
        assertEquals("Change the trump category to Specific gravity", trumpCard.getSubTitle());
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("Geophysisist", trumpCard.getTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        assertEquals("Slide59.jpg", trumpCard.getImageFilename());
    }

    @Test
    public void testType() throws Exception {
        assertEquals(CardType.TRUMP_CARD, trumpCard.getType());
    }

    @Test
    public void testGetPlayCardStats() throws Exception {
        assertTrue(new TrumpCardStats().equals(trumpCard.getStats()));
    }
}