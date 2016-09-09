package cmblack.card;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakePlayCardTest {

    @Test
    public void testGetCardDescription() throws Exception {
        IPlayCard playCard = new IPlayCard.FakePlayCard();
        assertTrue(playCard.getCardDescription().equals(new ICardDescription.FakeCardDescription()));
    }

    @Test
    public void testGetPlayCardStats() throws Exception {
    }

    @Test
    public void testGetTitle() throws Exception {
        IPlayCard playCard = new IPlayCard.FakePlayCard();
        assertEquals("Gold", playCard.getTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        IPlayCard playCard = new IPlayCard.FakePlayCard();
        assertEquals("Slide33.jpg", playCard.getImageFilename());
    }
}