package cmblack.player;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.controller.IRoundActions;
import cmblack.player.playerhand.IPlayerHand;
import cmblack.player.playerhand.PlayerHand;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class BotPlayerTest {
    IPlayerHand playerHand = new PlayerHand();
    IPlayer player = new BotPlayer("Bot1", playerHand);

    @Test
    public void testGetPlayerHand() throws Exception {
        assertTrue(player.getPlayerHand().equals(playerHand));
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Bot1", player.getName());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(player.equals(new BotPlayer("Bot1", playerHand)));
    }

    @Test
    public void testGetPlayerType() throws Exception {
        assertEquals(PlayerType.BOT, player.getPlayerType());
    }
}