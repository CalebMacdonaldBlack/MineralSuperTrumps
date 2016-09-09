package cmblack.card.playcard;

import cmblack.card.ICardDescription;
import cmblack.card.playcard.playcardstats.IPlayCardStats;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class PlayCardTest {

    IPlayCard playCard = new PlayCard(
            "Gold",
            "Slide33.jpg",
            new IPlayCardStats.FakePlayCardStats(),
            new ICardDescription.FakeCardDescription()
    );

    @Test
    public void testGetCardDescription() throws Exception {
        assertTrue(playCard.getCardDescription().equals(new ICardDescription.FakeCardDescription()));
    }

    @Test
    public void testGetPlayCardStats() throws Exception {
        assertTrue(playCard.getPlayCardStats().equals(new IPlayCardStats.FakePlayCardStats()));
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("Gold", playCard.getTitle());
    }

    @Test
    public void testGetImageFilename() throws Exception {
        assertEquals("Slide33.jpg", playCard.getImageFilename());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(playCard.equals(new IPlayCard.FakePlayCard()));
    }
}