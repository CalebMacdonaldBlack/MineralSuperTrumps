package cmblack.player.playerhand;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public class PlayerHandTest {

    IPlayerHand playerHand = new PlayerHand();

    @Test
    public void testGiveCard() throws Exception {
        playerHand.giveCard(new IPlayCard.FakePlayCard());
        assertTrue(playerHand.getCards().get(0).equals(new IPlayCard.FakePlayCard()));
    }

    @Test
    public void testRemoveCard() throws Exception {
        ICard card = new IPlayCard.FakeGoodPlayCard();
        playerHand.giveCard(card);
        assertTrue(playerHand.getCards().get(0).equals(card));
        assertEquals(1, playerHand.getCountOfCards());
        playerHand.removeCard(card);
        assertEquals(0, playerHand.getCountOfCards());
    }

    @Test
    public void testGetCards() throws Exception {
        playerHand.giveCard(new IPlayCard.FakeGoodPlayCard()).giveCard(new IPlayCard.FakePlayCard());
        assertTrue(playerHand.getCards().get(0).equals(new IPlayCard.FakeGoodPlayCard()));
        assertTrue(playerHand.getCards().get(1).equals(new IPlayCard.FakePlayCard()));
    }

    @Test
    public void testGetCountOfCards() throws Exception {
        assertEquals(2, playerHand
                .giveCard(new IPlayCard.FakeBadPlayCard())
                .giveCard(new IPlayCard.FakeGoodPlayCard())
                .getCountOfCards());
    }
}