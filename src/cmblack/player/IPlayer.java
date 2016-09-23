package cmblack.player;

import cmblack.player.playerhand.IPlayerHand;
import cmblack.player.playerhand.PlayerHand;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IPlayer {
    IPlayerHand getPlayerHand();
    String getName();
    boolean equals(IPlayer player);
    PlayerType getPlayerType();

    class FakePlayer implements IPlayer {

        private final IPlayerHand playerHand = new PlayerHand();

        @Override
        public IPlayerHand getPlayerHand() {
            return playerHand;
        }

        @Override
        public String getName() {
            return "Fake Bot";
        }

        @Override
        public boolean equals(IPlayer player) {
            return player.getName().equals(getName());
        }

        @Override
        public PlayerType getPlayerType() {
            return PlayerType.BOT;
        }
    }
}
