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

}