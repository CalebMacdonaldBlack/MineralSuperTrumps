package cmblack.player.round;

import cmblack.deck.IDeck;
import cmblack.player.IPlayer;

import java.io.FileNotFoundException;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRoundResult {
    IPlayer[] players();
    IDeck deck() throws FileNotFoundException;
    IPlayer roundWinningPlayer();
    IPlayer[] playersWhoWon();

    class FakeRoundResult implements IRoundResult {

        @Override
        public IPlayer[] players() {
            return new IPlayer[]{new IPlayer.FakePlayer(), new IPlayer.FakePlayer()};
        }

        @Override
        public IDeck deck() throws FileNotFoundException {
            return new IDeck.FakeDeck();
        }

        @Override
        public IPlayer roundWinningPlayer() {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayer[] playersWhoWon() {
            return new IPlayer[]{new IPlayer.FakePlayer()};
        }
    }
}
