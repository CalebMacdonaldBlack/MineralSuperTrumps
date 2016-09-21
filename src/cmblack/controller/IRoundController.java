package cmblack.controller;

import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public interface IRoundController {
    void selectCategory(IPlayer player);
    void selectCard(IPlayer player);
    void checkWin(IPlayer player);

    class FakeRoundController implements IRoundController {

        @Override
        public void selectCategory(IPlayer player) {

        }

        @Override
        public void selectCard(IPlayer player) {

        }

        @Override
        public void checkWin(IPlayer player) {

        }
    }
}
