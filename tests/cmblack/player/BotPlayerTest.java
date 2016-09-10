package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.Category;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class BotPlayerTest {

    @Test
    public void testAddCard() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        ICard card = new IPlayCard.FakePlayCard1();
        assertEquals(card, player.addCard(card).playCard(new IPlayCard.FakePlayCard(), new Category("Hardness")));
    }

    @Test
    public void testPlayCard() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        ICard card = new IPlayCard.FakePlayCard1();
        assertEquals(card, player.addCard(card).playCard(new IPlayCard.FakePlayCard(), new Category("Hardness")));
    }

    @Test
    public void testGetName() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        assertEquals("bot 11", player.getName());
    }
}