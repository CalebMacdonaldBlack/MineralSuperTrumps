package cmblack.player;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.controller.IRoundActions;
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
        assertEquals(card, player.addCard(card).getCards().get(player.getCountOfCards() - 1));
    }

    @Test
    public void testPlayCard() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        IRoundActions.FakeRoundActions roundActions = new IRoundActions.FakeRoundActions();
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        player.playCard(new IPlayCard.FakeBadPlayCard(), new ICategory.FakeCleavageCategory(), roundActions);
        assertTrue(roundActions.getCard().equals(new IPlayCard.FakeGoodPlayCard()));
    }

    @Test
    public void testGetName() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        assertEquals("bot 11", player.getName());
    }

    @Test
    public void testPlayCard1() throws Exception {
        IPlayer player = new BotPlayer("bot 11");
        IRoundActions.FakeRoundActions roundActions = new IRoundActions.FakeRoundActions();
        player.playCard(new IPlayCard.FakeGoodPlayCard(), new ICategory.FakeCleavageCategory(), roundActions);
        assertTrue(roundActions.getRemovedPlayer().equals(player));

    }

    @Test
    public void testPlayCard2() throws Exception {
        ICard card = new IPlayCard.FakePlayCard1();
        IPlayer player = new BotPlayer("bot 11").addCard(card);
        IRoundActions.FakeRoundActions fakeRoundActions = new IRoundActions.FakeRoundActions();
        player.playCard(new ITrumpCard.FakeTrumpCard(), new ICategory.FakeCleavageCategory(), fakeRoundActions);

        assertTrue(card.equals(fakeRoundActions.getCard()));
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
        assertTrue(category.equals(new CleavageCategory()));
    }

    @Test
    public void testGetCountOfCard() throws Exception {
        IPlayer player = new BotPlayer("bot1");
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        assertEquals(2, player.getCountOfCards());
    }

    @Test
    public void testGiveCard() throws Exception {
        IPlayer player = new BotPlayer("bot1");
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        assertEquals(2, player.getCountOfCards());
        player.addCard(new IPlayCard.FakeGoodPlayCard());
        assertEquals(3, player.getCountOfCards());
    }

    @Test
    public void testGiveCard1() throws Exception {
        IPlayer player = new BotPlayer("bot1");
        assertEquals(0, player.getCountOfCards());
        player.giveCard(new EmptyCard());
        assertEquals(0, player.getCountOfCards());
    }

    @Test(expected=NullPointerException.class)
    public void testPlayCard3() throws Exception {
        new BotPlayer("bot1").playCard(new IPlayCard.FakePlayCard(), new EmptyCategory(), new IRoundActions.FakeRoundActions());
    }
}