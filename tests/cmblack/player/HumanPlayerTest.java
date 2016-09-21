package cmblack.player;

import cmblack.player.playerhand.IPlayerHand;
import cmblack.player.playerhand.PlayerHand;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 20/09/2016.
 */
public class HumanPlayerTest {
    IPlayerHand playerHand = new PlayerHand();
    IPlayer player = new HumanPlayer("Caleb", playerHand);

    @Test
    public void testGetPlayerHand() throws Exception {
        assertTrue(playerHand.equals(player.getPlayerHand()));
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Caleb", player.getName());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(player.equals(new HumanPlayer("Caleb", playerHand)));
    }

    @Test
    public void testGetPlayerType() throws Exception {
        assertEquals(PlayerType.HUMAN, player.getPlayerType());
    }
}