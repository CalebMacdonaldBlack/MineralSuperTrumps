package cmblack.deck;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class JSONDeckBuilderTest {

    @Test
    public void testGetDeck() throws Exception {
        assertTrue(new JSONDeckBuilder().getDeck() instanceof Deck);
    }
}