package cmblack.player.round;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResultTest {

    IDeck deck = new IDeck.FakeDeck();

    IRoundResult roundResult = new RoundResult(
            new IPlayer[]{new IPlayer.FakePlayer()},
            new IPlayer.FakePlayer());


    @Test
    public void testRoundWinningPlayer() throws Exception {
        assertTrue(new IPlayer.FakePlayer().equals(roundResult.roundWinningPlayer()));
    }

    @Test
    public void testPlayersWhoWon() throws Exception {
        assertEquals(1, roundResult.playersWhoWon().length);
        assertTrue(new IPlayer.FakePlayer().equals(roundResult.playersWhoWon()[0]));
    }
}