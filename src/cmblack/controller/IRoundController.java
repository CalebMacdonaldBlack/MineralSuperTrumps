package cmblack.controller;

import cmblack.player.IPlayer;
import cmblack.player.round.ITurn;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public interface IRoundController {
    void findCategoryFromPlayer();
    void findCardFromPlayer();
    void nextPlayerTurn(IPlayer player);
    void checkWin(IPlayer player);
    ITurn getTurn();

    class FakeRoundController implements IRoundController {

        @Override
        public void findCategoryFromPlayer() {

        }

        @Override
        public void findCardFromPlayer() {

        }

        @Override
        public void nextPlayerTurn(IPlayer player) {

        }

        @Override
        public void checkWin(IPlayer player) {

        }

        public ITurn getTurn() {
            return null;
        }
    }
}
