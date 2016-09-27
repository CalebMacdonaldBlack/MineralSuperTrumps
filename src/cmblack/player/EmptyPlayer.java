package cmblack.player;

import cmblack.player.playerhand.IPlayerHand;
import cmblack.player.playerhand.PlayerHand;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class EmptyPlayer implements IPlayer {
    @Override
    public IPlayerHand getPlayerHand() {
        return new PlayerHand();
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean equals(IPlayer player) {
        return player.getName().equals("");
    }

    @Override
    public PlayerType getPlayerType() {
        return PlayerType.EMPTY;
    }
}
