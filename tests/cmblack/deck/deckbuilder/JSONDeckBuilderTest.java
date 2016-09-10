package cmblack.deck.deckbuilder;

import cmblack.deck.IDeck;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class JSONDeckBuilderTest {

    @Test
    public void testBuild() throws Exception {
        IDeckBuilder deckBuilder = new JSONDeckBuilder(new IJsonReaderWrapper.FakeJsonReaderWrapper().getReader());
        IDeck deck = deckBuilder.build();
        assertEquals(60, deck.length());
        assertEquals("Quartz", deck.takeCard().getTitle());
    }
}