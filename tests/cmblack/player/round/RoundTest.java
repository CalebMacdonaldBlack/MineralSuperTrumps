package cmblack.player.round;

import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class RoundTest {
    IDeck deck = new IDeck.FakeDeck();
    IRound round = new Round(new IPlayerGroup.FakePlayerGroup(), new IPlayCard.FakeGoodPlayCard(), deck, new ICategory.FakeCleavageCategory(), RoundState.START);

    @Test
    public void testGetPlayerGroup() throws Exception {
        assertTrue(round.getPlayerGroup().equals(new IPlayerGroup.FakePlayerGroup()));
    }

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
    public void testGetRoundState() throws Exception {
        assertTrue(round.getRoundState().equals(RoundState.START));
    }

    @Test
    public void testSetRoundState() throws Exception {
        assertTrue(round.getRoundState().equals(RoundState.START));
        IRound newRound = round.setRoundState(RoundState.CATEGORY_UPDATED);
        assertTrue(newRound.getRoundState().equals(RoundState.CATEGORY_UPDATED));
    }

    @Test
    public void testSetPlayerGroup() throws Exception {
        IPlayerGroup playerGroup = new IPlayerGroup.FakePlayerGroup();
        assertTrue(round.setPlayerGroup(playerGroup).getPlayerGroup().equals(playerGroup));
    }
}