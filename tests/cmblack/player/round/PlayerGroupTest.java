package cmblack.player.round;

import cmblack.player.BotPlayer;
import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroupTest {

    IPlayer player = new BotPlayer("bot1"), player2 = new BotPlayer("bot2");
    IPlayerGroup playerGroup = new PlayerGroup(new IPlayer[]{player, player2});

    @Test
    public void testGetNextPlayer() throws Exception {
        assertTrue(playerGroup.getNextPlayer(player).equals(player2));
    }

    @Test
    public void testGetNextPlayer1() throws Exception {
        assertTrue(playerGroup.getNextPlayer(player2).equals(player));
    }

    @Test
    public void testGetNextPlayer3() throws Exception {
        assertTrue(playerGroup.getNextPlayer(new EmptyPlayer()).equals(player));
    }

    @Test
    public void testRemovePlayer() throws Exception {
        playerGroup.removePlayer(player2);
        assertTrue(playerGroup.getNextPlayer(player).equals(player));
    }

    @Test
    public void testGetRemainingPLayers() throws Exception {
        assertEquals(2, playerGroup.getRemainingPlayers().size());
        playerGroup.removePlayer(player2);
        assertEquals(1, playerGroup.getRemainingPlayers().size());
    }

    @Test
    public void testGetRemovedPLayers() throws Exception {
        assertEquals(0, playerGroup.getRemovedPlayers().size());
        playerGroup.removePlayer(player2);
        assertEquals(1, playerGroup.getRemovedPlayers().size());
    }

    @Test
    public void testGetRoundWinningPlayer() throws Exception {
        assertTrue(playerGroup.getRoundWinningPlayer().equals(new EmptyPlayer()));
        assertTrue(playerGroup.removePlayer(player).getRoundWinningPlayer().equals(player2));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(playerGroup.equals(new PlayerGroup(new IPlayer[]{player, player2}))); //equals and throw exception on currentplayer
        assertFalse(playerGroup.equals(new IPlayerGroup.FakePlayerGroup()));
        assertFalse(playerGroup.equals(new PlayerGroup(new IPlayer[]{player, player2}, new IPlayer.FakePlayer(), playerGroup.getRemainingPlayers(), playerGroup.getRemovedPlayers())));
    }

    @Test
    public void testGetPlayerAt() throws Exception {
        assertTrue(player.equals(playerGroup.getPlayerAt(0)));
        assertTrue(player2.equals(playerGroup.getPlayerAt(1)));
    }

    @Test
    public void testGetCurrentPlayer() throws Exception {
        assertTrue(playerGroup.getCurrentPlayer().equals(player));
    }

    @Test
    public void testSetCurrentPlayer() throws Exception {
        IPlayerGroup newPlayerGroup = playerGroup.setCurrentPlayer(player2);
        assertTrue(newPlayerGroup.getCurrentPlayer().equals(player2));
    }

    @Test(expected=NullPointerException.class)
    public void testSetCurrentPlayer1() throws Exception {
        IPlayerGroup newPlayerGroup = playerGroup.setCurrentPlayer(new IPlayer.FakePlayer());
    }
}