package cmblack.game;

import cmblack.player.BotPlayer;
import cmblack.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 5/09/2016.
 */
public class PlayerCircleTest {

    @Test
    public void testGetNext() throws Exception {
        Player players[] = {
                new BotPlayer("bot one", null),
                new BotPlayer("bot two", null),
                new BotPlayer("bot three", null)
        };
        PlayerCircle playerCircle = new PlayerCircle(players);
        assertEquals("bot one", playerCircle.nextPlayer().getPlayerName());
        assertEquals("bot two", playerCircle.nextPlayer().getPlayerName());
        assertEquals("bot three", playerCircle.nextPlayer().getPlayerName());
        assertEquals("bot one", playerCircle.nextPlayer().getPlayerName());
    }

    @Test
    public void testGetNext2() throws Exception {
        Player player2 = new BotPlayer("bot two", null);

        Player players[] = {
                new BotPlayer("bot one", null),
                player2,
                new BotPlayer("bot three", null)
        };
        PlayerCircle playerCircle = new PlayerCircle(players);
        assertEquals("bot one", playerCircle.nextPlayer().getPlayerName());
        playerCircle.remove(player2);
        assertEquals("bot three", playerCircle.nextPlayer().getPlayerName());
    }

    @Test
    public void testGetNext3() throws Exception {
        Player player3 = new BotPlayer("bot three", null);

        Player players[] = {
                new BotPlayer("bot one", null),
                new BotPlayer("bot two", null),
                player3
        };
        PlayerCircle playerCircle = new PlayerCircle(players);
        assertEquals("bot one", playerCircle.nextPlayer().getPlayerName());
        playerCircle.remove(player3);
        assertEquals("bot two", playerCircle.nextPlayer().getPlayerName());
        assertEquals("bot one", playerCircle.nextPlayer().getPlayerName());
    }

    @Test
    public void testGetNext4() throws Exception {
        Player player3 = new BotPlayer("bot three", null);

        Player players[] = {
                new BotPlayer("bot one", null),
                new BotPlayer("bot two", null),
                player3
        };
        PlayerCircle playerCircle = new PlayerCircle(players);
        while(playerCircle.hasNext()){
            playerCircle.remove(playerCircle.nextPlayer());
        }
        assertEquals(player3, playerCircle.getRoundWinningPlayer());
    }

    @Test
    public void testGetNext5() throws Exception {
        Player player1 = new BotPlayer("bot one", null);
        Player player2 = new BotPlayer("bot two", null);
        Player player3 = new BotPlayer("bot three", null);

        Player players[] = {
                player1,
                player2,
                player3
        };
        PlayerCircle playerCircle = new PlayerCircle(players);
        playerCircle.remove(player1);
        playerCircle.remove(player3);
        playerCircle.resetRoundUsingWinningPlayer();
        assertEquals(player2, playerCircle.nextPlayer());
        assertEquals(player3, playerCircle.nextPlayer());
    }

    @Test
    public void testGetNext6() throws Exception {
        Player player1 = new BotPlayer("bot one", null);
        Player player2 = new BotPlayer("bot two", null);
        Player player3 = new BotPlayer("bot three", null);

        Player players[] = {
                player1,
                player2,
                player3
        };
        PlayerCircle playerCircle = new PlayerCircle(players);
        playerCircle.remove(player2);
        playerCircle.remove(player3);
        playerCircle.resetRoundUsingWinningPlayer();
        assertEquals(player1, playerCircle.nextPlayer());
    }
}