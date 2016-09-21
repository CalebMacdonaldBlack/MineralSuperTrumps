package cmblack.player;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public class EmptyPlayerTest {

    IPlayer player = new EmptyPlayer();

    @Test
    public void testGetPlayerHand() throws Exception {
        assertEquals(0, player.getPlayerHand().getCountOfCards());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("", player.getName());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(player.equals(new EmptyPlayer()));
    }

    @Test
    public void testGetPlayerType() throws Exception {
        assertEquals(PlayerType.EMPTY, player.getPlayerType());
    }
}