package cmblack.deck;

import cmblack.deck.deckbuilder.IDeckBuilder;
import cmblack.deck.deckbuilder.IJsonReaderWrapper;
import cmblack.deck.deckbuilder.JSONDeckBuilder;
import org.junit.Test;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class JSONDeckBuilderTest {

    @Test
    public void testBuild() throws Exception {
        IDeckBuilder deckBuilder = new JSONDeckBuilder(new IJsonReaderWrapper.FakeJsonReaderWrapper().getReader());
    }
}