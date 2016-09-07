package cmblack.game;

import cmblack.deck.Deck;
import cmblack.deck.JSONDeckBuilder;
import cmblack.player.BotPlayer;
import cmblack.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 7/09/2016.
 */
public class GameTest {

    @Test
    public void TestGamePlayed() throws Exception{
        JSONDeckBuilder jsonDeckBuilder = new JSONDeckBuilder("cards.json");
        Deck deck = jsonDeckBuilder.getDeck().shuffle();

        Player[] players = new Player[]{
                new BotPlayer("bot1"),
                new BotPlayer("bot2"),
                new BotPlayer("bot3"),
                new BotPlayer("bot4"),
                new BotPlayer("bot5")
        };

        Game game = new Game(players, deck);

        game.start();
    }

}