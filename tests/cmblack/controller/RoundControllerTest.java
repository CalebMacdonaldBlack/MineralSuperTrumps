package cmblack.controller;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.EmptyCategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.category.hardness.HardnessCategory;
import cmblack.deck.IDeck;
import cmblack.player.BotAI;
import cmblack.player.HumanPlayer;
import cmblack.player.IPlayer;
import cmblack.player.playerhand.PlayerHand;
import cmblack.player.round.IRound;
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
    RoundController roundController = new RoundController(round, new BotAI());

    @Test
    public void testGetRound() throws Exception {
        assertEquals(round, roundController.getRound());
    }

    @Test
    public void testSelectedCategory() throws Exception {
        roundController.selectedCategory(new HardnessCategory());
        assertTrue(roundController.getRound().getCurrentCategory().equals(new HardnessCategory()));
    }

    @Test
    public void testSelectedCard() throws Exception {
        ICard card = new IPlayCard.FakePlayCard();
        roundController.getRound().getCurrentPlayer().getPlayerHand().giveCard(card);
        roundController.selectedCard(card);
        assertEquals(0, roundController.getRound().getCurrentPlayer().getPlayerHand().getCountOfCards());
        assertTrue(roundController.getRound().getCurrentCard().equals(card));
    }

    @Test
    public void testFindCategoryFromPlayer() throws Exception {
        roundController.getRound().getCurrentPlayer().getPlayerHand().giveCard(new IPlayCard.FakeGoodPlayCard()).giveCard(new IPlayCard.FakeGoodPlayCard());
        roundController.findCategoryFromPlayer();
        assertTrue(new CleavageCategory().equals(roundController.getRound().getCurrentCategory()));
    }

    @Test
    public void testFindCardFromPlayer() throws Exception {
        roundController.selectedCategory(new CleavageCategory());
        roundController.selectedCard(new IPlayCard.FakeBadPlayCard());
        roundController.getRound().getCurrentPlayer().getPlayerHand().giveCard(new IPlayCard.FakeBadPlayCard()).giveCard(new IPlayCard.FakeGoodPlayCard());
        roundController.findCardFromPlayer();
        assertTrue(roundController.getRound().getCurrentCard().equals(new IPlayCard.FakeGoodPlayCard()));
    }

    @Test
    public void testFindCardFromPlayer1() throws Exception {
        roundController.selectedCategory(new CleavageCategory());
        roundController.selectedCard(new IPlayCard.FakeGoodPlayCard());
        roundController.getRound().getCurrentPlayer().getPlayerHand().giveCard(new IPlayCard.FakeBadPlayCard());
        roundController.findCardFromPlayer();
        assertTrue(roundController.getRound().getCurrentCard().equals(new IPlayCard.FakeGoodPlayCard()));
    }

    @Test
    public void testFindCardFromPlayer2() throws Exception {
        roundController.selectedCategory(new CleavageCategory());
        roundController.selectedCard(new IPlayCard.FakeGoodPlayCard());
        roundController.getRound().getCurrentPlayer().getPlayerHand().giveCard(new IPlayCard.FakeBadPlayCard()).giveCard(new ITrumpCard.FakeTrumpCard());
        roundController.findCardFromPlayer();
        assertTrue(roundController.getRound().getCurrentCard().equals(new ITrumpCard.FakeTrumpCard()));
    }

    @Test
    public void testFindCardFromPlayer3() throws Exception {
        roundController.selectedCategory(new CleavageCategory());
        roundController.selectedCard(new IPlayCard.FakeBadPlayCard());
        roundController.getRound().getCurrentPlayer().getPlayerHand().giveCard(new IPlayCard.FakeGoodPlayCard()).giveCard(new ITrumpCard.FakeTrumpCard());
        roundController.findCardFromPlayer();
        assertTrue(roundController.getRound().getCurrentCard().equals(new IPlayCard.FakeGoodPlayCard()));
    }

    @Test
    public void testCheckWin() throws Exception {
        // TODO: 23/9/16  
        //maybe remove this and have a class higher up check
        //also note that higher up class is managing the players now and passing current player in round
        //higher up class will get round result and maybe call another game/menu whatever controller for other things
        
    }
}