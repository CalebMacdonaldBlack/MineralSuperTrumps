package cmblack.player.round;

import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import cmblack.player.playerhand.PlayerHand;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResultTest {

    IDeck deck = new IDeck.FakeDeck();
    IPlayer[] players = new IPlayer[]{new BotPlayer("bot1", new PlayerHand()), new BotPlayer("bot2", new PlayerHand())};
    IPlayer roundWinngPlayer = players[0];

    IRoundResult roundResult = new RoundResult(roundWinngPlayer, players);

    @Test
    public void testRoundWinningPlayer() throws Exception {
        assertTrue(roundWinngPlayer.equals(roundResult.getRoundWinningPlayer()));
    }

    @Test
    public void testPlayers() throws Exception {
        assertEquals(2, roundResult.getPlayers().length);
        assertTrue(players[0].equals(roundResult.getPlayers()[0]));
        assertTrue(players[1].equals(roundResult.getPlayers()[1]));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(roundResult.equals(new RoundResult(roundWinngPlayer, players)));
    }
}