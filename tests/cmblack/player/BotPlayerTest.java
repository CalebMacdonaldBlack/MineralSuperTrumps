package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.card.PlayCardStats;
import cmblack.card.TrumpCard;
import cmblack.category.*;
import cmblack.deck.Deck;
import cmblack.game.PlayerCircle;
import cmblack.game.Round;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 29/08/2016.
 */
public class BotPlayerTest {

    @Test
    public void testChooseCategory() {
        BotPlayer bot = new BotPlayer("Bot One", null);
        Round round = new Round(null, null, new ArrayList<Player>());
        boolean isCategory = false;
        switch (bot.chooseCategory()) {
            case "Cleavage":
                isCategory = true;
                break;
            case "Crustal abundance":
                isCategory = true;
                break;
            case "Economic value":
                isCategory = true;
                break;
            case "Hardness":
                isCategory = true;
                break;
            case "Specific gravity":
                isCategory = true;
                break;
        }
        assertEquals(isCategory, true);
    }

    @Test
    public void testFindValidCardToPlay() {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);
        String[] occurrences = new String[]{"sedementry", "surface"};

        ArrayList<Card> cards = new ArrayList<>();
        Card card = new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        cards.add(card);


        Player[] players = {
                new BotPlayer("botOne", cards),
                new BotPlayer("botTwo", null)
        };
        Round round = new Round(null, new PlayerCircle(players),  new ArrayList<Player>());
        ((BotPlayer) players[0]).findValidCardToPlay(round);
        assertEquals(card, round.getCurrentCard());
    }

    @Test
    public void testFindValidCardToPlay2() {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);

        Hardness hardness2 = new Hardness(2.2, 2.5);
        PlayCardStats playCardStats2 = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness2, specificGravity);

        String[] occurrences = new String[]{"sedementry", "surface"};

        Player[] players = {
                new BotPlayer("botOne", new ArrayList<Card>()),
                new BotPlayer("botTwo", null)
        };
        Round round = new Round(null, new PlayerCircle(players),  new ArrayList<Player>());
        round.setCategory(Category.Categories.HARDNESS.getName());
        round.setCurrentCard(new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats));
        hardness = new Hardness(2, 3);
        Card newCard = new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats2);
        players[0].giveCard(newCard);
        ((BotPlayer) players[0]).findValidCardToPlay(round);
        assertEquals(newCard, round.getCurrentCard());
    }

    @Test
    public void testFindValidCardToPlay3() {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);

        Hardness hardness2 = new Hardness(2.2, 2.5);
        PlayCardStats playCardStats2 = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness2, specificGravity);

        String[] occurrences = new String[]{"sedementry", "surface"};

        Player[] players = {
                new BotPlayer("botOne", new ArrayList<Card>()),
                new BotPlayer("botTwo", null)
        };
        Round round = new Round(null, new PlayerCircle(players),  new ArrayList<Player>());
        round.setCategory(Category.Categories.HARDNESS.getName());
        round.setCurrentCard(new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats));
        hardness = new Hardness(2, 3);
        Card newCard = new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats2);
        String[] categories = {"Hardness"};
        TrumpCard trumpCard = new TrumpCard("title", "subTitle", "filename.png", categories);
        players[0].giveCard(trumpCard);
        players[0].giveCard(newCard);
        ((BotPlayer) players[0]).findValidCardToPlay(round);
        assertEquals(newCard, round.getCurrentCard());
    }

    @Test
    public void testFindValidCardToPlay4() {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);

        String[] occurrences = new String[]{"sedementry", "surface"};

        Player[] players = {
                new BotPlayer("botOne", new ArrayList<Card>()),
                new BotPlayer("botTwo", null)
        };
        Round round = new Round(null, new PlayerCircle(players),  new ArrayList<Player>());
        round.setCategory(Category.Categories.HARDNESS.getName());
        round.setCurrentCard(new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats));
        String[] categories = {"Hardness"};
        TrumpCard trumpCard = new TrumpCard("title", "subTitle", "filename.png", categories);
        players[0].giveCard(trumpCard);
        ((BotPlayer) players[0]).findValidCardToPlay(round);
        assertEquals(trumpCard, round.getCurrentCard());
    }

    @Test
    public void testFindValidCardToPlay5() {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);

        String[] occurrences = new String[]{"sedementry", "surface"};

        Player[] players = {
                new BotPlayer("botOne", new ArrayList<Card>()),
                new BotPlayer("botTwo", null)
        };
        Round round = new Round(null, new PlayerCircle(players),  new ArrayList<Player>());
        round.setCategory(Category.Categories.HARDNESS.getName());
        round.setCurrentCard(new TrumpCard("title", "subTitle", "filename.png", new String[]{"Hardness"}));
        Card card = new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats);
        players[0].giveCard(card);
        ((BotPlayer) players[0]).findValidCardToPlay(round);
        assertEquals(card, round.getCurrentCard());
    }

    @Test
    public void testFindValidCardToPlay6() {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);

        Hardness hardness2 = new Hardness(2.2, 2.5);
        PlayCardStats playCardStats2 = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness2, specificGravity);

        String[] occurrences = new String[]{"sedementry", "surface"};

        Player[] players = {
                new BotPlayer("botOne", new ArrayList<Card>()),
                new BotPlayer("botTwo", null)
        };
        ArrayList<Card> deckList = new ArrayList<>();
        deckList.add(new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats2));
        Round round = new Round(new Deck(deckList, null), new PlayerCircle(players),  new ArrayList<Player>());
        round.setCategory(Category.Categories.HARDNESS.getName());
        Card newCard = new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats2);
        round.setCurrentCard(newCard);
        players[0].giveCard(new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats));
        ((BotPlayer) players[0]).findValidCardToPlay(round);
        assertEquals(newCard, round.getCurrentCard());
        assertEquals(players[1], round.getPlayerCircle().getRoundWinningPlayer());
        assertEquals(2, players[0].getCards().size());
    }

    @Test
    public void testFindValidCardToPlay7() {
        SpecificGravity specificGravity = new SpecificGravity(1.7, 2);
        Hardness hardness = new Hardness(1.2, 1.5);
        EconomicValue economicValue = new EconomicValue(EconomicValue.EconomicValueOptions.IM_RICH);
        CrustalAbundance crustalAbundance = new CrustalAbundance(CrustalAbundance.CrustalAbundanceOptions.HIGH);
        Cleavage cleavage = new Cleavage(Cleavage.CleavageOptions.GOOD1);
        PlayCardStats playCardStats = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness, specificGravity);

        Hardness hardness2 = new Hardness(2.2, 2.5);
        PlayCardStats playCardStats2 = new PlayCardStats(cleavage, crustalAbundance, economicValue, hardness2, specificGravity);

        String[] occurrences = new String[]{"sedementry", "surface"};

        Player[] players = {
                new BotPlayer("botOne", new ArrayList<Card>()),
                new BotPlayer("botTwo", null)
        };
        ArrayList<Card> deckList = new ArrayList<>();
        deckList.add(new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats2));
        Round round = new Round(new Deck(deckList, null), new PlayerCircle(players),  new ArrayList<Player>());
        round.setCategory(Category.Categories.HARDNESS.getName());
        Card newCard = new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats2);
        round.setCurrentCard(newCard);
        players[0].giveCard(new PlayCard("Title", "Filename.txt", "Al(O H)3", "hydroxide", "orthorhombic", occurrences, playCardStats));
        ((BotPlayer) players[0]).findValidCardToPlay(round);
        assertEquals(players[1], round.getPlayerCircle().getRoundWinningPlayer());
        round.reset();
        players[0].giveCard(newCard);
        players[0].giveCard(newCard);
        assertEquals(null, round.getCategory());
        assertEquals(null, round.getCurrentCard());
        players[0].haveTurn(round);
        assertTrue(round.getCategory() != null);
        assertTrue(round.getCurrentCard() != null);
    }
}