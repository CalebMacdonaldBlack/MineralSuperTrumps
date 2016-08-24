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
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};
        assertEquals("title", new TrumpCard("title", "subTitle", "filename.png", categories).getTitle());
    }

    @Test
    public void testGetSubTitle() throws Exception {
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};
        assertEquals("subTitle", new TrumpCard("title", "subTitle", "filename.png", categories).getSubTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};
        assertEquals("filename.png", new TrumpCard("title", "subTitle", "filename.png", categories).getImageFilename());
    }

    @Test
    public void testGetCategories() throws Exception {
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};
        assertEquals(categories, new TrumpCard("title", "subTitle", "filename.png", categories).getCategories());

    }
}