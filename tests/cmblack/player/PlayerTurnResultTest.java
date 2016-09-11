package cmblack.player;

import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.player.turn.IPlayerTurnResult;
import cmblack.player.turn.PlayerTurnResult;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class PlayerTurnResultTest {

    IPlayerTurnResult playerTurnResult = new PlayerTurnResult(new IPlayCard.FakePlayCard(), new IPlayer.FakePlayer(), new ICategory.FakeCleavageCategory());

    @Test
    public void testGetCurrentCard() throws Exception {
        assertTrue(playerTurnResult.getCurrentCard().equals(new IPlayCard.FakePlayCard()));
    }

    @Test
    public void testGetCurrentPlayer() throws Exception {
        assertTrue(playerTurnResult.getCurrentPlayer().equals(new IPlayer.FakePlayer()));
    }

    @Test
    public void testGetCurrentCategory() throws Exception {
        assertTrue(playerTurnResult.getCurrentCategory().equals(new ICategory.FakeCleavageCategory()));
    }
}