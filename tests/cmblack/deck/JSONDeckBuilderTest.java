package cmblack.deck;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class JSONDeckBuilderTest {

    @Test
    public void testBuild() throws Exception {
        IDeckBuilder deckBuilder = new JSONDeckBuilder(new IJsonReaderWrapper.FakeJsonReaderWrapper().getReader());
    }
}