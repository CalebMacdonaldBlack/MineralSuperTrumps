package cmblack.player.round;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRoundResult {
    IPlayer roundWinningPlayer();
    IPlayer[] playersStillIn();
    IPlayer[] playersWithNoCards();
    boolean equals(IRoundResult roundResult);

    class FakeRoundResult implements IRoundResult {

        @Override
        public IPlayer roundWinningPlayer() {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayer[] playersStillIn() {
            return new IPlayer[]{new IPlayer.FakePlayer()};
        }

        @Override
        public IPlayer[] playersWithNoCards() {
            return new IPlayer[]{new IPlayer.FakePlayer()};
        }

        @Override
        public boolean equals(IRoundResult roundResult) {
            throw new NotImplementedException();
        }
    }
}
