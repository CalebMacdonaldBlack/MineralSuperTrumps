package cmblack.deck;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 25/08/2016.
 */
public class ParsedCardTest {

    @Test
    public void testGetFileName() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null
        );
            assertEquals("Slide01.jpg", parsedCard.getFileName());
    }

    @Test
    public void testGetTitle() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null
        );
        assertEquals("Quartz", parsedCard.getTitle());
    }

    @Test
    public void testGetChemistry() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null
        );
        assertEquals("SiO_2", parsedCard.getChemistry());
    }

    @Test
    public void testGetClassification() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null);
        assertEquals("tectosilicate", parsedCard.getClassification());
    }

    @Test
    public void testGetCrystal_system() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null);
        assertEquals("hexagonal", parsedCard.getCrystal_system());
    }

    @Test
    public void testGetHardness() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null);
        assertEquals("7", parsedCard.getHardness());
    }

    @Test
    public void testGetSpecific_gravity() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null);
        assertEquals("2.65", parsedCard.getSpecific_gravity());
    }

    @Test
    public void testGetCleavage() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null
        );
        assertEquals("poor/none", parsedCard.getCleavage());
    }

    @Test
    public void testGetCrustal_abundance() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null
        );
        assertEquals("high", parsedCard.getCrustal_abundance());
    }

    @Test
    public void testGetEconomic_value() throws Exception {
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                new String[]{"igneous", "metamorphic", "sedimentary"},
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null
        );
        assertEquals("moderate", parsedCard.getEconomic_value());
    }

    @Test
    public void testGetOccurrence() throws Exception {
        String[] occurrence = new String[]{"igneous", "metamorphic", "sedimentary"};
        ParsedCard parsedCard = new ParsedCard(
                "SiO_2",
                "7",
                "hexagonal",
                "Quartz",
                "tectosilicate",
                "2.65",
                occurrence,
                "Slide01.jpg",
                "poor/none",
                "moderate",
                "high",
                null,
                null
        );
        assertEquals(occurrence, parsedCard.getOccurrence());
    }

    @Test
    public void testGetSubTitle() throws Exception {
        //Trump Card
        String[] categories = new String[]{"HARDNESS", "CLEAVAGE", "CRUSTAL_ABUNDANCE"};
        ParsedCard parsedCard = new ParsedCard(
                null,
                null,
                null,
                "The Geologist",
                null,
                null,
                null,
                "Slide01.jpg",
                null,
                null,
                null,
                "Change to trumps category of your choice",
                categories
        );
        assertEquals("Change to trumps category of your choice", parsedCard.getSubTitle());
    }

    @Test
    public void testGetCategories() throws Exception {
        String[] categories = new String[]{"HARDNESS", "CLEAVAGE", "CRUSTAL_ABUNDANCE"};
        //Trump Card
        ParsedCard parsedCard = new ParsedCard(
                null,
                null,
                null,
                "The Geologist",
                null,
                null,
                null,
                "Slide01.jpg",
                null,
                null,
                null,
                "Change to trumps category of your choice",
                categories
        );
        assertEquals(categories, parsedCard.getCategories());
    }
}