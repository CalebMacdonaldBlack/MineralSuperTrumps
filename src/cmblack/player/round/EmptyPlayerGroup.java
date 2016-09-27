package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 26/9/16.
 */
public class EmptyPlayerGroup implements IPlayerGroup {
    @Override
    public IPlayer[] getPlayersStillInGame() {
        return new IPlayer[0];
    }

    @Override
    public IPlayer[] getPlayersStillInRound() {
        return new IPlayer[0];
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return new EmptyPlayer();
    }

    @Override
    public IPlayerGroup nextPlayerTurn() {
        return this;
    }

    @Override
    public boolean equals(IPlayerGroup playerGroup) {
        return playerGroup.getCurrentPlayer().equals(getCurrentPlayer())
            && playerGroup.getPlayersStillInGame().length == 0
            && playerGroup.getPlayersStillInRound().length == 0;
    }

    @Override
    public IPlayerGroup removePlayerFromRound(IPlayer player) {
        return this;
    }

    @Override
    public IPlayerGroup removePlayerFromGame(IPlayer player) {
        return this;
    }
}
