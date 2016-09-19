package cmblack.game;

import cmblack.player.IPlayer;
import cmblack.player.round.IRoundResult;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public interface IGameActions {
    void RoundFinished(IRoundResult roundResult);

    void playerRemovedFromGame(IPlayer player);

    void dealCards();

    void startGame();

    class FakeGameActions implements IGameActions {

        @Override
        public void RoundFinished(IRoundResult roundResult) {

        }

        @Override
        public void playerRemovedFromGame(IPlayer player) {

        }

        @Override
        public void dealCards() {

        }

        @Override
        public void startGame() {

        }
    }
}
