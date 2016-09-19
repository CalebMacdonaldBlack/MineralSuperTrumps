package cmblack.player.round;

import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResultTest {

    IDeck deck = new IDeck.FakeDeck();
    IPlayer[] playersStillIn = new IPlayer[]{new BotPlayer("bot1"), new BotPlayer("bot2")};
    IPlayer roundWinngPlayer = playersStillIn[0];
    IPlayer[] playersWithNoCards = new IPlayer[]{new BotPlayer("bot3")};

    IRoundResult roundResult = new RoundResult(roundWinngPlayer, playersStillIn, playersWithNoCards);

    @Test
    public void testRoundWinningPlayer() throws Exception {
        assertTrue(roundWinngPlayer.equals(roundResult.roundWinningPlayer()));
    }

    @Test
    public void testPlayersStillIn() throws Exception {
        assertEquals(2, roundResult.playersStillIn().length);
        assertTrue(playersStillIn[0].equals(roundResult.playersStillIn()[0]));
        assertTrue(playersStillIn[1].equals(roundResult.playersStillIn()[1]));
    }

    @Test
    public void testPlayersWithNoCards() throws Exception {
        assertTrue(playersWithNoCards[0].equals(roundResult.playersWithNoCards()[0]));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(roundResult.equals(new RoundResult(roundWinngPlayer, playersStillIn, playersWithNoCards)));
    }
}