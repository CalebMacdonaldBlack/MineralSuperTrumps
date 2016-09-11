package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;
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

        IPlayerTurn turn = new PlayerTurn(new IPlayCard.FakeBadPlayCard(), player,  new ICategory.FakeCleavageCategory());
        IPlayerTurnResult playerTurnResult = turn.haveTurn();
        assertTrue(goodCard.equals(playerTurnResult.getCurrentCard()));
    }

    @Test
    public void haveTurn2() throws FileNotFoundException {
        IPlayer player = new BotPlayer("Bot 1");
        ICard goodCard = new IPlayCard.FakeGoodPlayCard();
        ICard badCard = new IPlayCard.FakeBadPlayCard();

        player.addCard(badCard);

        IPlayerTurn turn = new PlayerTurn(goodCard, player,  new ICategory.FakeCleavageCategory());
        IPlayerTurnResult playerTurnResult = turn.haveTurn();
        assertTrue(goodCard.equals(playerTurnResult.getCurrentCard()));
    }

}