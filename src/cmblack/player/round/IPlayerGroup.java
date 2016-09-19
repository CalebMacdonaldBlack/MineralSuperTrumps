package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
    IPlayer getPlayerAt(int index);
    boolean equals(IPlayerGroup playerGroup);
    IPlayer getCurrentPlayer();
    IPlayerGroup setCurrentPlayer(IPlayer player);


    class FakePlayerGroup implements IPlayerGroup {

        private IPlayer removedPlayer;
        private IPlayer nextPlayer;

        @Override
        public IPlayer getNextPlayer(IPlayer player) {
            this.nextPlayer = player;
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayerGroup removePlayer(IPlayer player) {
            this.removedPlayer = player;
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

        @Override
        public IPlayer getPlayerAt(int index) {
            return new IPlayer.FakePlayer();
        }

        @Override
        public boolean equals(IPlayerGroup playerGroup) {
            return playerGroup.getRemainingPlayers().size() == 0
                && playerGroup.getRemovedPlayers().size() == 0;
        }

        @Override
        public IPlayer getCurrentPlayer() {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayerGroup setCurrentPlayer(IPlayer player) {
            return this;
        }

        public IPlayer getRemovedPlayer() {
            return removedPlayer;
        }

        public IPlayer getNextPlayer() {
            return nextPlayer;
        }
    }
}
