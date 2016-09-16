package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class EmptyRoundResultTest {

    IRoundResult roundResult = new EmptyRoundResult();

    @Test
    public void testRoundWinningPlayer() throws Exception {

        assertTrue(roundResult.roundWinningPlayer().equals(new EmptyPlayer()));
    }

    @Test
    public void testPlayersWhoWon() throws Exception {
        assertEquals(0, roundResult.playersWhoWon().length);
    }
}