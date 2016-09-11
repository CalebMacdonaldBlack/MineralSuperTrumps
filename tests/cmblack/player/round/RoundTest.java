package cmblack.player.round;

import cmblack.card.playcard.IPlayCard;
import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundTest {

    @Test
    public void testHaveRound() throws Exception {
        IPlayer bot1 = new BotPlayer("bot1");
        IPlayer bot2 = new BotPlayer("bot1");

        bot1.addCard(new IPlayCard.FakeBadPlayCard());
        bot1.addCard(new IPlayCard.FakeGoodPlayCard());

        bot2.addCard(new IPlayCard.FakeBadPlayCard());
        bot2.addCard(new IPlayCard.FakeGoodPlayCard());

        IRound round = new Round(
                new IDeck.FakeDeck(),
                new IPlayer[]{bot1, bot2},
                bot2);

        IRoundResult roundResult = round.haveRound();
        assertTrue(roundResult.playersWhoWon().equals(bot1));
    }
}