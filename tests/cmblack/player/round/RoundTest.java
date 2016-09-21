package cmblack.player.round;

import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.playerhand.PlayerHand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundTest {
    IDeck deck = new IDeck.FakeDeck();
    IRound round = new Round(new IPlayCard.FakeGoodPlayCard(), deck, new ICategory.FakeCleavageCategory(), new BotPlayer("name", new PlayerHand()));

    @Test
    public void testGetCurrentCard() throws Exception {
        assertTrue(round.getCurrentCard().equals(new IPlayCard.FakeGoodPlayCard()));
    }

    @Test
    public void testGetDeck() throws Exception {
        assertTrue(round.getDeck().equals(deck));
    }

    @Test
    public void testGetCurrentCategory() throws Exception {
        assertTrue(round.getCurrentCategory().equals(new ICategory.FakeCleavageCategory()));
    }

    @Test
    public void testSetCurrentCard() throws Exception {
        IRound newRound = round.setCurrentCard(new IPlayCard.FakeBadPlayCard());
        assertTrue(newRound.getCurrentCard().equals(new IPlayCard.FakeBadPlayCard()));
    }

    @Test
    public void testSetCurrentCategory() throws Exception {
        IRound newRound = round.setCurrentCategory(new ICategory.FakeHardnessCategory());
        assertTrue(newRound.getCurrentCategory().equals(new ICategory.FakeHardnessCategory()));
    }

    @Test
    public void testCurrentPlayer() throws Exception {
        assertTrue(new BotPlayer("name", new PlayerHand()).equals(round.getCurrentPlayer()));
    }

    @Test
    public void testSetCurrentPlayer() throws Exception {
        IRound newRound = round.setCurrentPlayer(new BotPlayer("bot1", new PlayerHand()));
        assertTrue(newRound.getCurrentPlayer().equals(new BotPlayer("bot1", new PlayerHand())));
    }
}