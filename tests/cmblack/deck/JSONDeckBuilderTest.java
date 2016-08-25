package cmblack.deck;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class JSONDeckBuilderTest {

    @Test
    public void testGetDeck() throws Exception {
        assertTrue(new JSONDeckBuilder("cards.json").getDeck() instanceof Deck);
    }

    @Test
    public void testGetDeck1() throws Exception {
        String jsonString = "{\n" +
                "  \"cards\": [\n" +
                "    {\n" +
                "      \"fileName\": \"Slide01.jpg\",\n" +
                "      \"imageName\": \"Slide01\",\n" +
                "      \"title\": \"Quartz\",\n" +
                "      \"chemistry\": \"SiO_2\",\n" +
                "      \"classification\": \"tectosilicate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"7\",\n" +
                "      \"specific_gravity\": \"2.65\",\n" +
                "      \"cleavage\": \"poor/none\",\n" +
                "      \"crustal_abundance\": \"high\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ParsedCardsArray parsedCardsArray = new Gson().fromJson(jsonString, ParsedCardsArray.class);
        assertTrue(new JSONDeckBuilder(parsedCardsArray).getDeck() instanceof Deck);
    }
}