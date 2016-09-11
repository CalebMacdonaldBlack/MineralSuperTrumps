package cmblack.player.round;

import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public interface IPlayerGroup {
    IPlayer getNextPlayer(IPlayer player);
    IPlayer removePlayer(IPlayer player);
    ArrayList<IPlayer> getRemainingPlayers();
    ArrayList<IPlayer> getRemovedPlayers();

    class FakePlayerGroup implements IPlayerGroup {

        @Override
        public IPlayer getNextPlayer(IPlayer player) {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayer removePlayer(IPlayer player) {
            return player;
        }

        @Override
        public ArrayList<IPlayer> getRemainingPlayers() {
            return new ArrayList<IPlayer>();
        }

        @Override
        public ArrayList<IPlayer> getRemovedPlayers() {
            return new ArrayList<IPlayer>();
        }
    }
}
