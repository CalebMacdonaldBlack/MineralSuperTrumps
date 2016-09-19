package cmblack.game;

import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import cmblack.player.round.IRoundView;
import cmblack.player.round.PlayerGroup;
import org.junit.Test;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class GameTest {
    @Test
    public void testStartGame() throws Exception {
        IGame game = new Game(new PlayerGroup(new IPlayer[]{new BotPlayer("bot1"),new BotPlayer("bot2"),new BotPlayer("bot3")}), new IDeck.FakeDeck(), new IRoundView.FakeRoundView());
        game.startGame();
    }
}