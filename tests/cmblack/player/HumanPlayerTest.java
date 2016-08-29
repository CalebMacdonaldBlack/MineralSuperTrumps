package cmblack.player;

import cmblack.card.Card;
import cmblack.player.HumanPlayer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 26/08/2016.
 */
public class HumanPlayerTest {

    @Test
    public void testGetPlayerName() throws Exception {
        assertEquals("Player1" , new HumanPlayer("Player1", new ArrayList<Card>()).getPlayerName());
    }

    @Test
    public void testGetCards() throws Exception {
        ArrayList<Card> cards = new ArrayList<Card>();
        assertEquals(cards, new HumanPlayer("Caleb", cards).getCards());
    }
}