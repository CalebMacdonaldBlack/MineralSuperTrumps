package cmblack.player.round;

import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroupTest {
    IPlayer[] players = new IPlayer[]{new BotPlayer("bot1"), new BotPlayer("bot2"), new BotPlayer("bot3")};
    IPlayerGroup playerGroup = new PlayerGroup(players, players[0]);


    @Test
    public void testGetAllPlayers() throws Exception {
        assertEquals(3, playerGroup.getAllPlayers().length);
    }

    @Test
    public void testGetPlayersStillIn() throws Exception {
        playerGroup = playerGroup.removePlayerFromRound(players[0]);
        assertEquals(2, playerGroup.getPlayersStillIn().length);
    }

    @Test
    public void testGetCurrentPlayer() throws Exception {
        assertTrue(playerGroup.getCurrentPlayer().equals(players[0]));
        IPlayerGroup playerGroup1 = playerGroup.nextPlayerTurn();
        assertTrue(playerGroup1.getCurrentPlayer().equals(players[1]));
    }

    @Test
    public void testGetCurrentPlayer1() throws Exception {
        assertTrue(playerGroup.getCurrentPlayer().equals(players[0]));
    }

    @Test
    public void testNextPlayerTurn() throws Exception {
        IPlayerGroup playerGroup1 = playerGroup.removePlayerFromRound(players[1]);
        assertTrue(playerGroup1.getCurrentPlayer().equals(players[0]));
        assertTrue(playerGroup1.nextPlayerTurn().getCurrentPlayer().equals(players[2]));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(playerGroup.equals(new PlayerGroup(players, players[0])));
        assertFalse(playerGroup.equals(new IPlayerGroup.FakePlayerGroup()));
    }

    @Test
    public void testRemovePlayerFromGame() throws Exception {
        assertEquals(3, playerGroup.getAllPlayers().length);
        IPlayerGroup playerGroup1 = playerGroup.removePlayerFromGame(players[0]);
        assertEquals(2, playerGroup1.getAllPlayers().length);
    }
}