package cmblack.game;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public interface IGame {
    void startGame();

    class FakeGame implements IGame {

        @Override
        public void startGame() {

        }
    }
}
