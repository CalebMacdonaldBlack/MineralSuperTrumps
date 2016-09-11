package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public interface IPlayerGroup {
    IPlayer getNextPlayer(IPlayer player);
    IPlayerGroup removePlayer(IPlayer player);
    ArrayList<IPlayer> getRemainingPlayers();
    ArrayList<IPlayer> getRemovedPlayers();
    IPlayer getRoundWinningPlayer();


    class FakePlayerGroup implements IPlayerGroup {

        @Override
        public IPlayer getNextPlayer(IPlayer player) {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayerGroup removePlayer(IPlayer player) {
            return this;
        }

        @Override
        public ArrayList<IPlayer> getRemainingPlayers() {
            return new ArrayList<IPlayer>();
        }

        @Override
        public ArrayList<IPlayer> getRemovedPlayers() {
            return new ArrayList<IPlayer>();
        }

        @Override
        public IPlayer getRoundWinningPlayer() {
            return new EmptyPlayer();
        }
    }
}
