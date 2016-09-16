package cmblack.player.round.turn;

import cmblack.card.EmptyCard;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.player.EmptyPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class EmptyTurnResultTest {

    IPlayerTurnResult playerTurnResult = new EmptyTurnResult();

    @Test
    public void testGetCurrentCard() throws Exception {
        assertTrue(new EmptyCard().equals(playerTurnResult.getCurrentCard()));
    }

    @Test
    public void testGetCurrentPlayer() throws Exception {
        assertTrue(new EmptyPlayer().equals(playerTurnResult.getCurrentPlayer()));
    }

    @Test
    public void testGetCurrentCategory() throws Exception {
        assertTrue(new EmptyCategory().equals(playerTurnResult.getCurrentCategory()));
    }

    @Test
    public void testEquals() throws Exception {
        assertFalse(new EmptyTurnResult().equals(new IPlayerTurnResult.FakePlayerTurnResult()));
        assertTrue(new EmptyTurnResult().equals(new EmptyTurnResult()));
    }
}