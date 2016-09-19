package cmblack.game;

import cmblack.controller.GameController;
import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.IPlayer;
import cmblack.player.round.*;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class GameTest {

    IPlayer[] players = new IPlayer[]{new BotPlayer("bot 1"), new BotPlayer("bot 2"), new BotPlayer("bot 3")};
    IGame game = new Game(players, new IDeck.FakeDeck(), new IRoundView.FakeRoundView(), GameState.START , new RoundResult[]{}, new IPlayer[]{});

    @Test
    public void testStartGame1() throws Exception {
        IGame game = new Game(players, new IDeck.FakeDeck(), new RoundView(), GameState.START, new RoundResult[0], new IPlayer[0]);
        GameController gameController = new GameController(new GameView(), game);
        gameController.dealCards();
        gameController.startGame();
    }

    @Test
    public void testGetGameState() throws Exception {
        assertEquals(GameState.START, game.getGameState());
    }

    @Test
    public void testDealCards() throws Exception {
        game.dealCards();
        assertEquals(5, players[0].getCountOfCards());
        assertEquals(5, players[1].getCountOfCards());
        assertEquals(5, players[2].getCountOfCards());
    }

    @Test
    public void testSetGameState() throws Exception {
        IGame newGame = game.setGameState(GameState.ROUND_OVER);
        assertEquals(GameState.ROUND_OVER, newGame.getGameState());
    }

    @Test
    public void testAddWinningPlayer() throws Exception {
        IPlayer player = new BotPlayer("bot 1");
        assertTrue(game.addWinningPlayer(player).getWinningPlayers()[0].equals(player));
    }

    @Test
    public void testGetRoundResults() throws Exception {
        assertEquals(0, game.getRoundResults().length);
    }

    @Test
    public void testAddRoundResult() throws Exception {
        assertEquals(0, game.getRoundResults().length);
        IGame game1 = game.addRoundResult(new IRoundResult.FakeRoundResult());
        assertEquals(1, game1.getRoundResults().length);
    }
}