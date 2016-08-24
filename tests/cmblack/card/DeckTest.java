package cmblack.card;

import cmblack.category.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 24/08/2016.
 */
public class DeckTest {

    @Test
    public void testGetCards() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};

        Card card1 = new PlayCard("Title","SubTitle","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats);
        Card card2 = new TrumpCard("title", "subTitle", "filename.png", categories);
        Card[] cards = {card1, card2};
        assertEquals(cards, new Deck(cards).getCards());
    }
}