package cmblack.game;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;
import cmblack.player.round.IRoundResult;
import cmblack.player.round.RoundResult;

import java.io.FileNotFoundException;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public interface IGame {
    IGame startRound(IGameActions gameActions);
    GameState getGameState();
    IGame dealCards();
    IGame setGameState(GameState roundOver);
    IGame addWinningPlayer(IPlayer player);
    IPlayer[] getWinningPlayers();
    IRoundResult[] getRoundResults();
    IGame addRoundResult(IRoundResult roundResult);

    class FakeGame implements IGame {

        @Override
        public IGame startRound(IGameActions gameActions) {
            return this;
        }

        @Override
        public GameState getGameState() {
            return GameState.START;
        }

        @Override
        public IGame dealCards() {
            return null;
        }

        @Override
        public IGame setGameState(GameState roundOver) {
            return this;
        }

        @Override
        public IGame addWinningPlayer(IPlayer player) {
            return this;
        }

        @Override
        public IPlayer[] getWinningPlayers() {
            return new IPlayer[]{};
        }

        @Override
        public RoundResult[] getRoundResults() {
            return new RoundResult[0];
        }

        @Override
        public IGame addRoundResult(IRoundResult roundResult) {
            return this;
        }
    }
}
