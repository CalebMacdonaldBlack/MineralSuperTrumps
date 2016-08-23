package cmblack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class TrumpCardTest {

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("title", new TrumpCard("title", "", "").getTitle());
    }

    @Test
    public void testGetSubTitle() throws Exception {
        assertEquals("subTitle", new TrumpCard("", "subTitle", "").getSubTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        assertEquals("filename.png", new TrumpCard("", "", "filename.png"));
    }
}