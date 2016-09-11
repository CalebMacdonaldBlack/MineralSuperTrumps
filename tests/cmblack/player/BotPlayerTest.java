package cmblack.player;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.Category;
import cmblack.category.ICategory;
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
        assertEquals(card, player.addCard(card).playCard(new IPlayCard.FakePlayCard(), new ICategory.FakeHardnessCategory()));
    }

    @Test
    public void testPlayCard() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        ICard card = new IPlayCard.FakePlayCard1();
        assertEquals(card, player.addCard(card).playCard(new IPlayCard.FakePlayCard(), new ICategory.FakeHardnessCategory()));
    }

    @Test
    public void testGetName() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        assertEquals("bot 11", player.getName());
    }

    @Test
    public void testPlayCard1() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        ICard card = new IPlayCard.FakePlayCard1();
        ICard card2 = new IPlayCard.FakePlayCard();
        assertTrue(new EmptyCard().equals(player.addCard(card2).playCard(card, new ICategory.FakeHardnessCategory())));
    }

    @Test
    public void testPlayCard2() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        ICard card = new IPlayCard.FakePlayCard1();
        assertTrue(new ITrumpCard.FakeTrumpCard().equals(player.addCard(new ITrumpCard.FakeTrumpCard()).playCard(card, new ICategory.FakeHardnessCategory())));
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new BotPlayer("bot1").equals(new BotPlayer("bot1")));
        assertFalse(new BotPlayer("bot2").equals(new BotPlayer("bot1")));
    }

    @Test
    public void testChooseCategory() throws Exception {
        IPlayer player = new BotPlayer("bot1");
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        ICategory category = player.chooseCategory();
    }
}