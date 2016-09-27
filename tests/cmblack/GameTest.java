package cmblack;

import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.HumanPlayer;
import cmblack.player.IPlayer;
import cmblack.player.playerhand.PlayerHand;
import cmblack.player.round.PlayerGroup;
import cmblack.view.View;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 26/9/16.
 */
public class GameTest {

    @Test
    public void testStartGame() throws Exception {
        IPlayer[] players = new IPlayer[]{
                new HumanPlayer("bot 1", new PlayerHand()),
                new BotPlayer("bot 2", new PlayerHand()),
                new BotPlayer("bot 3", new PlayerHand())
        };
        IGame game = new Game(new IDeck.FakeDeck(), new PlayerGroup(players), new View());
        game.startGame();
    }
}