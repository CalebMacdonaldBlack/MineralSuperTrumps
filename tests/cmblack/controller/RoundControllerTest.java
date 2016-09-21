package cmblack.controller;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.EmptyCategory;
import cmblack.category.hardness.HardnessCategory;
import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.HumanPlayer;
import cmblack.player.IPlayer;
import cmblack.player.playerhand.PlayerHand;
import cmblack.player.round.IRound;
import cmblack.player.round.PlayerGroup;
import cmblack.player.round.Round;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public class RoundControllerTest {
    IPlayer currentPlayer = new HumanPlayer("Bot1", new PlayerHand());
    // TODO: 21/9/16 Make a fake
    IRound round = new Round(
            new EmptyCard(),
            new IDeck.FakeDeck(),
            new EmptyCategory(),
            currentPlayer
            );
    RoundController roundController = new RoundController(round);

    @Test
    public void testGetRound() throws Exception {
        assertEquals(round, roundController.getRound());
    }

    @Test
    public void testSelectedCategory() throws Exception {
        roundController.selectedCategory(new HardnessCategory());
        assertTrue(round.getCurrentCategory().equals(new HardnessCategory()));
    }

    @Test
    public void testSelectedCard() throws Exception {
        ICard card = new IPlayCard.FakePlayCard();
        round.getCurrentPlayer().getPlayerHand().giveCard(card);
        roundController.selectedCard(card);
        assertEquals(0, round.getCurrentPlayer().getPlayerHand().getCountOfCards());
        assertTrue(round.getCurrentCard().equals(card));
    }

    @Test
    public void testFindCategoryFromPlayer() throws Exception {
        // botAI.getBestCategory(player)
        assertTrue(false);
    }

    @Test
    public void testFindCardFromPlayer() throws Exception {
        // botAI.getBestCard(player)
        assertTrue(false);
    }

    @Test
    public void testCheckWin() throws Exception {
        //maybe remove this and have a class higher up check
        //also note that higher up class is managing the players now and passing current player in round
        //higher up class will get round result and maybe call another game/menu whatever controller for other things
        syntax error for note
    }
}