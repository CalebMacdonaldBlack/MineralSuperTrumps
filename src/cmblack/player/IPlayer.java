package cmblack.player;

import cmblack.player.playerhand.IPlayerHand;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IPlayer {
    IPlayerHand getPlayerHand();
    String getName();
    boolean equals(IPlayer player);
    PlayerType getPlayerType();

    class FakePlayer implements IPlayer {

        @Override
        public IPlayerHand getPlayerHand() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean equals(IPlayer player) {
            return false;
        }

        @Override
        public PlayerType getPlayerType() {
            return null;
        }
    }
}
