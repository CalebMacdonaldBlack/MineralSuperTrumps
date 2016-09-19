package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public interface IPlayerGroup {
    IPlayer[] getAllPlayers();
    IPlayer[] getPlayersStillIn();
    IPlayer getCurrentPlayer();
    IPlayerGroup nextPlayerTurn();
    boolean equals(IPlayerGroup playerGroup);
    IPlayerGroup removePlayerFromRound(IPlayer player);




    class FakePlayerGroup implements IPlayerGroup {

        @Override
        public IPlayer[] getAllPlayers() {
            return new IPlayer[0];
        }

        @Override
        public IPlayer[] getPlayersStillIn() {
            return new IPlayer[0];
        }

        @Override
        public IPlayer getCurrentPlayer() {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayerGroup nextPlayerTurn() {
            return this;
        }

        @Override
        public boolean equals(IPlayerGroup playerGroup) {
            return playerGroup.getPlayersStillIn().length == 0
                && playerGroup.getAllPlayers().length == 0;
        }

        @Override
        public IPlayerGroup removePlayerFromRound(IPlayer player) {
            return this;
        }
    }
}
