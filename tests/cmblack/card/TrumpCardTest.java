package cmblack.card;

import cmblack.card.TrumpCard;
import cmblack.category.Category;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class TrumpCardTest {

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("title", new TrumpCard("title", "", "", null).getTitle());
    }

    @Test
    public void testGetSubTitle() throws Exception {
        assertEquals("subTitle", new TrumpCard("", "subTitle", "", null).getSubTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        assertEquals("filename.png", new TrumpCard("", "", "filename.png", null).getImageFilename());
    }

    @Test
    public void testGetCategories() throws Exception {
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};
        assertEquals(categories, new TrumpCard("", "", "", categories));
        
    }
}