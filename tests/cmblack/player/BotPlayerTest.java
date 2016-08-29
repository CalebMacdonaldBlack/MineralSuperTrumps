package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.card.PlayCardStats;
import cmblack.category.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 29/08/2016.
 */
public class BotPlayerTest {

    @Test
    public void testHaveTurn() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        specificGravity = new SpecificGravity(2.7, 3.5);
        PlayCard currentCard = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card1);

        Player player = new BotPlayer("SuperBot", cards);
        player.haveTurn("Hardness", currentCard, null, null);
        assertEquals(currentCard, card1);
    }

    @Test
    public void testGetPlayerName() throws Exception {

    }

    @Test
    public void testGetCards() throws Exception {

    }

    @Test
    public void testGiveCard() throws Exception {

    }

    @Test
    public void testGetCountOfCards() throws Exception {

    }

    @Test
    public void testHaveTurn1() throws Exception {

    }
}