package cmblack.game;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

import java.io.FileNotFoundException;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public interface IGame {
    void startGame() throws FileNotFoundException;
    GameState getGameState();

    class FakeGame implements IGame {

        @Override
        public void startGame() {

        }

        @Override
        public GameState getGameState() {
            return GameState.START;
        }
    }
}
