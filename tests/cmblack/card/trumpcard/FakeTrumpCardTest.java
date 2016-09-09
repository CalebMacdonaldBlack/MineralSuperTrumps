package cmblack.card.trumpcard;

import cmblack.category.Category;
import cmblack.category.ICategory;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakeTrumpCardTest {

    ITrumpCard trumpCard = new ITrumpCard.FakeTrumpCard();

    @Test
    public void testGetCategories() throws Exception {
        boolean arraysAreEqual = true;
        ICategory[] categories = new ICategory[]{new Category("Cleavage")};
        for(int i=0;i<trumpCard.getCategories().length;i++){
            if(!trumpCard.getCategories()[i].equals(categories[i])){
                arraysAreEqual = false;
            }
        }
        assertTrue(arraysAreEqual);
    }

    @Test
    public void testGetSubTitle() throws Exception {
        assertEquals("Changes the trump category to Cleavage", trumpCard.getSubTitle());
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("The Mineralogist", trumpCard.getTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        assertEquals("slide58.jpg", trumpCard.getImageFilename());
    }
}