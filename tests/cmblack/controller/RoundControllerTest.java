package cmblack.controller;

import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.IPlayerGroup;
import cmblack.player.round.IRound;
import cmblack.player.round.IRoundView;
import cmblack.player.round.RoundState;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public class RoundControllerTest {
    IRound round = new IRound.FakeRound();
    IRoundActions roundActions = new RoundController(round, new IRoundView.FakeRoundView());

    @Test
    public void testChangeCategory() throws Exception {
        assertTrue(round.getCurrentCategory().equals(new ICategory.FakeCleavageCategory()));
        roundActions.changeCategory(new ICategory.FakeSpecificGravityCategory());
        assertTrue(round.getCurrentCategory().equals(new ICategory.FakeSpecificGravityCategory()));
        assertTrue(round.getRoundState().equals(RoundState.CATEGORY_UPDATED));
    }

    @Test
    public void testPlayACard() throws Exception {
        assertTrue(round.getCurrentCard().equals(new IPlayCard.FakePlayCard()));
        roundActions.playACard(new IPlayCard.FakePlayCard1());
        assertTrue(round.getCurrentCard().equals(new IPlayCard.FakePlayCard1()));
        assertTrue(round.getRoundState().equals(RoundState.PLAYER_PLAYED_CARD));
    }

    @Test
    public void testRemoveAPlayer() throws Exception {
        roundActions.removeAPlayer(new IPlayer.FakePlayer());
        assertTrue(new IPlayer.FakePlayer().equals(((IPlayerGroup.FakePlayerGroup)round.getPlayerGroup()).getRemovedPlayer()));
        assertTrue(round.getRoundState().equals(RoundState.PLAYER_REMOVED));
    }

    @Test
    public void testNextPlayerTurn() throws Exception {
        roundActions.nextPlayerTurn(new IPlayer.FakePlayer());
        assertTrue(((IPlayerGroup.FakePlayerGroup)round.getPlayerGroup()).getNextPlayer().equals(new IPlayer.FakePlayer()));
        assertTrue(round.getRoundState().equals(RoundState.PLAYER_FINISHED_TURN));
    }
}