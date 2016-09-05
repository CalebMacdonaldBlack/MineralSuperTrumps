package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.card.PlayCardStats;
import cmblack.card.TrumpCard;
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
        ArrayList<Player> players = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 2.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        hardness = new Hardness(0.5, 1);
        playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        PlayCard currentCard = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card1);

        Player player = new BotPlayer("SuperBot", cards);
        players.add(player);
        Card playedCard = player.getCardToPlay("Hardness", currentCard, null);
        assertEquals(playedCard, card1);
    }

    @Test
    public void testHaveTurn1() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 2.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        hardness = new Hardness(0.5, 3);
        playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        PlayCard currentCard = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card1);

        Player player = new BotPlayer("SuperBot", cards);
        players.add(player);

        Card playedCard = player.getCardToPlay("Hardness", currentCard, null);
        assertNotEquals(playedCard, card1);
    }

    @Test
    public void testHaveTurn3() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 2.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        hardness = new Hardness(0.5, 2);
        playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        PlayCard currentCard = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card1);

        Player player = new BotPlayer("SuperBot", cards);
        players.add(player);

        Card playedCard = player.getCardToPlay("Hardness", currentCard, null);
        assertTrue(players.contains(player));
    }

    @Test
    public void testHaveTurn4() throws Exception {
        //TODO Fakes/mocks for all this
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 2.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        hardness = new Hardness(0.5, 3);
        playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        Card trumpCard = new TrumpCard("title", "subTitle", "filename.png", new String[]{"category", "category", "category", "category"});
        PlayCard currentCard = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);

        cards.add(card1);
        cards.add(trumpCard);


        Player player = new BotPlayer("SuperBot", cards);
        players.add(player);

        Card playedCard = player.getCardToPlay("Hardness", currentCard, null);
        assertEquals(playedCard, trumpCard);

    }

    @Test
    public void testGetPlayerName() throws Exception {
        Player player = new BotPlayer("Caleb", null);
        assertEquals("Caleb", player.getPlayerName());
    }

    @Test
    public void testGetCards() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 2.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        Card card2 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card1);
        cards.add(card2);

        Player player = new BotPlayer("SuperBot", cards);
        assertEquals(cards, player.getCards());
    }

    @Test
    public void testGiveCard() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 2.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        Card card2 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card1);

        Player player = new BotPlayer("SuperBot", cards);
        player.giveCard(card2);
        assertTrue(player.getCards().contains(card2));
    }

    @Test
    public void testGetCountOfCards() throws Exception {
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();

        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 2.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        Card card1 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        Card card2 = new PlayCard("Orthopyroxene", "Slide14.jpg", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card1);
        cards.add(card2);

        Player player = new BotPlayer("SuperBot", cards);
        assertEquals(2, player.getCountOfCards());
    }
}