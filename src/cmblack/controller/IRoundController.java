package cmblack.controller;

import cmblack.player.IPlayer;
import cmblack.player.round.IRound;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public interface IRoundController {
    void findCategoryFromPlayer();
    void findCardFromPlayer();
    void nextPlayerTurn(IPlayer player);
    void checkWin(IPlayer player);
    IRound getRound();

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

        @Override
        public IRound getRound() {
            return null;
        }
    }
}
