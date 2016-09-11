package cmblack.player.round;

import cmblack.player.BotPlayer;
import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroupTest {

    @Test
    public void testGetNextPlayer() throws Exception {
        IPlayer player = new BotPlayer("bot1"), player2 = new BotPlayer("bot2");
        IPlayerGroup playerGroup = new PlayerGroup(new IPlayer[]{player, player2});
        assertTrue(playerGroup.getNextPlayer(player).equals(player2));
    }

    @Test
    public void testGetNextPlayer1() throws Exception {
        IPlayer player = new BotPlayer("bot1"), player2 = new BotPlayer("bot2");
        IPlayerGroup playerGroup = new PlayerGroup(new IPlayer[]{player, player2});
        assertTrue(playerGroup.getNextPlayer(player2).equals(player));
    }

    @Test
    public void testGetNextPlayer3() throws Exception {
        IPlayer player = new BotPlayer("bot1"), player2 = new BotPlayer("bot2");
        IPlayerGroup playerGroup = new PlayerGroup(new IPlayer[]{player, player2});
        assertTrue(playerGroup.getNextPlayer(new EmptyPlayer()).equals(player));
    }

    @Test
    public void testRemovePlayer() throws Exception {
        IPlayer player = new BotPlayer("bot1"), player2 = new BotPlayer("bot2"), player3 = new BotPlayer("bot3");
        IPlayerGroup playerGroup = new PlayerGroup(new IPlayer[]{player, player2, player3});
        playerGroup.removePlayer(player2);
        assertTrue(playerGroup.getNextPlayer(player).equals(player3));
    }

    @Test
    public void testGetRemainingPLayers() throws Exception {
        IPlayer player = new BotPlayer("bot1"), player2 = new BotPlayer("bot2"), player3 = new BotPlayer("bot3");
        IPlayerGroup playerGroup = new PlayerGroup(new IPlayer[]{player, player2, player3});
        assertEquals(3, playerGroup.getRemainingPlayers().size());
        playerGroup.removePlayer(player2);
        assertEquals(2, playerGroup.getRemainingPlayers().size());
    }

    @Test
    public void testGetRemovedPLayers() throws Exception {
        IPlayer player = new BotPlayer("bot1"), player2 = new BotPlayer("bot2"), player3 = new BotPlayer("bot3");
        IPlayerGroup playerGroup = new PlayerGroup(new IPlayer[]{player, player2, player3});
        assertEquals(0, playerGroup.getRemovedPlayers().size());
        playerGroup.removePlayer(player2);
        assertEquals(1, playerGroup.getRemovedPlayers().size());
    }
}