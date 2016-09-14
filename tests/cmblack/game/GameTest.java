package cmblack.game;

import cmblack.deck.IDeck;
import cmblack.deck.deckbuilder.IDeckBuilder;
import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class GameTest {

    @Test
    public void testStartGame() throws Exception {
        IPlayer[] players = new IPlayer[]{
                new BotPlayer("bot1"),
                new BotPlayer("bot2"),
                new BotPlayer("bot3"),
                new BotPlayer("bot4")
        };


        new Game(players, new IDeckBuilder.FakeDeckBuilder().build()).startGame();
    }
}