package cmblack.controller;

import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.IPlayerGroup;
import cmblack.player.round.IRound;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public class RoundControllerTest {
    IRound round = new IRound.FakeRound();
    IRoundActions roundActions = new RoundController(round);

    @Test
    public void testChangeCategory() throws Exception {
        assertTrue(round.getCurrentCategory().equals(new ICategory.FakeCleavageCategory()));
        roundActions.changeCategory(new ICategory.FakeSpecificGravityCategory());
        assertTrue(round.getCurrentCategory().equals(new ICategory.FakeSpecificGravityCategory()));
    }

    @Test
    public void testPlayACard() throws Exception {
        assertTrue(round.getCurrentCard().equals(new IPlayCard.FakePlayCard()));
        roundActions.playACard(new IPlayCard.FakePlayCard1());
        assertTrue(round.getCurrentCard().equals(new IPlayCard.FakePlayCard1()));
    }

    @Test
    public void testRemoveAPlayer() throws Exception {
        roundActions.removeAPlayer(new IPlayer.FakePlayer());
        assertTrue(new IPlayer.FakePlayer().equals(((IPlayerGroup.FakePlayerGroup)round.getPlayerGroup()).getRemovedPlayer()));
    }

    @Test
    public void testNextPlayerTurn() throws Exception {
        roundActions.nextPlayerTurn(new IPlayer.FakePlayer());
        assertTrue(((IPlayerGroup.FakePlayerGroup)round.getPlayerGroup()).getNextPlayer().equals(new IPlayer.FakePlayer()));
    }
}