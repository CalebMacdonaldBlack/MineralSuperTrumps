package cmblack.deck;

import cmblack.player.HumanPlayer;
import cmblack.player.Player;
import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.card.PlayCardStats;
import cmblack.card.TrumpCard;
import cmblack.category.*;
import org.junit.Test;

import java.util.ArrayList;

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

        Card card1 = new PlayCard("Title","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats);
        Card card2 = new TrumpCard("title", "subTitle", "filename.png", categories);
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        assertEquals(cards, new Deck(cards, new ArrayList<Card>()).getCards());
    }

    @Test
    public void testTakeCard() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};

        Card card1 = new PlayCard("Title","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats);
        Card card2 = new TrumpCard("title", "subTitle", "filename.png", categories);
        ArrayList<Card> cards = new ArrayList<Card>();
        Deck deck = new Deck(cards, new ArrayList<Card>());
        cards.add(card1);
        cards.add(card2);
        assertEquals(card1, deck.takeCard());
        assertEquals(card2, deck.takeCard());
    }

    @Test
    public void testShuffle() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};

        Card card1 = new PlayCard("Title","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats);
        Card card2 = new TrumpCard("title", "subTitle", "filename.png", categories);
        ArrayList<Card> cards = new ArrayList<Card>();
        Deck deck = new Deck(cards, new ArrayList<Card>());
        cards.add(card2);
        for(int i=0;i<=100;i++){
            cards.add(card1);
        }

        assertNotEquals(card2, deck.shuffle().takeCard());
    }

    @Test
    public void testGetDiscardedCards() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};

        Card card1 = new PlayCard("Title","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats);
        Card card2 = new TrumpCard("title", "subTitle", "filename.png", categories);
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<Card> discardedCards = new ArrayList<Card>();
        Deck deck = new Deck(cards, discardedCards);
        assertEquals(discardedCards, deck.getDiscardedCards());
    }

    @Test
    public void testAddToDiscardedPile() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};

        Card card1 = new PlayCard("Title","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats);
        Card card2 = new TrumpCard("title", "subTitle", "filename.png", categories);
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<Card> discardedCards = new ArrayList<Card>();
        Deck deck = new Deck(cards, discardedCards);
        assertEquals(card1, deck.addToDiscardedPile(card1).getDiscardedCards().get(0));
    }

    @Test
    public void testDistributeToPlayers() throws Exception {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};
        Category[] categories = {new Category("Cleavage"),new Category("Cleavage"),new Category("Cleavage")};

        Card card1 = new PlayCard("Title","Filename.txt","Al(O H)3","hydroxide","orthorhombic",occurrences, playCardStats);
        Card card2 = new TrumpCard("title", "subTitle", "filename.png", categories);
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        for(int count=0;count<=51;count++){
            cards.add(card2);
        }
        Deck deck = new Deck(cards, new ArrayList<>());
        Player[] players = new Player[]{new HumanPlayer("john"), new HumanPlayer("Jake"), new HumanPlayer("caleb")};
        deck.distributeToPlayers(8, players);
        assertEquals(card1, players[0].getCards().get(0));
        assertEquals(8, players[2].getCards().size());
    }
}