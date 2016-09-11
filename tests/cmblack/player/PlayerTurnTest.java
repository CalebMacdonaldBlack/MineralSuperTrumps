package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.deck.deckbuilder.IDeckBuilder;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class PlayerTurnTest {

    @Test
    public void haveTurn() throws FileNotFoundException {
        IPlayer player = new BotPlayer("Bot 1");
        ICard goodCard = new IPlayCard.FakeGoodPlayCard();

        player.addCard(goodCard);

        IPlayerTurn turn = new PlayerTurn(new IPlayCard.FakeBadPlayCard(), player,  new ICategory.FakeCleavageCategory(), new IDeckBuilder.FakeDeckBuilder().build());
        IPlayerTurnResult playerTurnResult = turn.haveTurn();
        assertTrue(goodCard.equals(playerTurnResult.getCurrentCard()));
    }

    @Test
    public void haveTurn2() throws FileNotFoundException {
        IPlayer player = new BotPlayer("Bot 1");
        ICard goodCard = new IPlayCard.FakeGoodPlayCard();
        ICard badCard = new IPlayCard.FakeBadPlayCard();

        player.addCard(badCard);

        IPlayerTurn turn = new PlayerTurn(goodCard, player,  new ICategory.FakeCleavageCategory(), new IDeckBuilder.FakeDeckBuilder().build());
        IPlayerTurnResult playerTurnResult = turn.haveTurn();
        assertTrue(goodCard.equals(playerTurnResult.getCurrentCard()));
    }

    @Test
    public void haveTurn3() throws FileNotFoundException {
        IPlayer player = new BotPlayer("Bot 1");
        ICard goodCard = new IPlayCard.FakeGoodPlayCard();
        ICard trumpCard = new ITrumpCard.FakeTrumpCard();

        player.addCard(trumpCard);
        player.addCard(goodCard);
        player.addCard(goodCard);

        IPlayerTurn turn = new PlayerTurn(goodCard, player,  new ICategory.FakeCleavageCategory(), new IDeckBuilder.FakeDeckBuilder().build());
        IPlayerTurnResult playerTurnResult = turn.haveTurn();
        assertTrue(trumpCard.equals(playerTurnResult.getCurrentCard()));
        assertTrue(new CleavageCategory().equals(playerTurnResult.getCurrentCategory()));
    }

    @Test
    public void haveTurn4() throws FileNotFoundException {
        IPlayer player = new BotPlayer("Bot 1");
        ICard goodCard = new IPlayCard.FakeGoodPlayCard();

        player.addCard(goodCard);
        player.addCard(goodCard);

        IPlayerTurn turn = new PlayerTurn(goodCard, player, new ICategory.FakeCleavageCategory(), new IDeckBuilder.FakeDeckBuilder().build());
        assertEquals(2, player.getCountOfCard());
        IPlayerTurnResult playerTurnResult = turn.haveTurn();
        assertEquals(3, player.getCountOfCard());
    }

}