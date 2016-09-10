package cmblack.card;

import cmblack.card.playcard.IPlayCard;
import cmblack.card.stats.IStats;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class FakePlayCardTest {

    IPlayCard playCard = new IPlayCard.FakePlayCard();

    @Test
    public void testGetCardDescription() throws Exception {
        assertTrue(playCard.getCardDescription().equals(new ICardDescription.FakeCardDescription()));
    }

    @Test
    public void testGetPlayCardStats() throws Exception {
        assertTrue(playCard.getPlayCardStats().equals(new IStats.FakePlayCardStats()));
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("Gold", playCard.getTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        assertEquals("Slide33.jpg", playCard.getImageFilename());
    }
}