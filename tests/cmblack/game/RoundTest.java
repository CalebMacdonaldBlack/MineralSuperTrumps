package cmblack.game;

import cmblack.deck.Deck;
import cmblack.deck.JSONDeckBuilder;
import cmblack.player.BotPlayer;
import cmblack.player.Player;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 2/09/2016.
 */
public class RoundTest {

    @Test
    public void testStartRound() throws Exception {
        JSONDeckBuilder jsonDeckBuilder = new JSONDeckBuilder("cards.json");
        Deck deck = jsonDeckBuilder.getDeck().shuffle();

        Player[] players = new Player[]{
                new BotPlayer("bot1"),
                new BotPlayer("bot2"),
                new BotPlayer("bot3"),
                new BotPlayer("bot4"),
                new BotPlayer("bot5")
        };
        deck.distributeToPlayers(5, players);
        Round round = new Round(deck, new PlayerCircle(players), new ArrayList<Player>());
        round.begin();
        assertTrue(round.getPlayerCircle().getRoundWinningPlayer() != null);
    }
}