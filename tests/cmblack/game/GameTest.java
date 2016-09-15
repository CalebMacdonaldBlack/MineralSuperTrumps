package cmblack.game;

import cmblack.UserInterface;
import cmblack.deck.deckbuilder.IDeckBuilder;
import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import org.junit.Test;

import java.util.ArrayList;

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

        ArrayList<IGameObserver> gameObservers = new ArrayList<>();
        gameObservers.add(new UserInterface());
        new Game(players, new IDeckBuilder.FakeDeckBuilder().build(), gameObservers).startGame();
    }
}