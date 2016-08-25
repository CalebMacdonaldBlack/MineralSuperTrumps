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
                "high"
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
                "high"
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
                "high"
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
                "high"
        );
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
                "high"
        );
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
                "high"
        );
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
                "high"
        );
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
                "high"
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
                "high"
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
                "high"
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
                "high"
        );
        assertEquals(occurrence, parsedCard.getOccurrence());
    }
}