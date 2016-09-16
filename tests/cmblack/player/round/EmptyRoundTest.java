package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.round.turn.EmptyTurnResult;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class EmptyRoundTest {

    IRound round = new EmptyRound();

    @Test
    public void testHaveRound() throws Exception {
        assertTrue(new EmptyRoundResult().equals(round.haveRound()));
    }

    @Test
    public void testGetRoundState() throws Exception {
        assertEquals(RoundState.START, round.getRoundState());
    }

    @Test
    public void testGetCurrentPlayer() throws Exception {
        assertTrue(new EmptyPlayer().equals(round.getCurrentPlayer()));
    }

    @Test
    public void testGetPlayerTurnResult() throws Exception {
        assertTrue(new EmptyRound().getPlayerTurnResult().equals(new EmptyTurnResult()));
    }

    @Test
    public void testGetWinners() throws Exception {
        assertEquals(0, round.getWinners().size());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new EmptyRound().equals(new EmptyRound()));
    }
}