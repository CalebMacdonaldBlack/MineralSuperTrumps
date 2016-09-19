package cmblack.player.round;

import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResult implements IRoundResult {

    private final IPlayer roundWinningPlayer;
    private final IPlayer[] players;

    public RoundResult(IPlayer roundWinningPlayer, IPlayer[] players) {
        this.roundWinningPlayer = roundWinningPlayer;
        this.players = players;
    }

    @Override
    public IPlayer getRoundWinningPlayer() {
        return roundWinningPlayer;
    }

    @Override
    public IPlayer[] getPlayers() {
        return players;
    }
    @Override
    public boolean equals(IRoundResult roundResult) {
        return this.players.length == roundResult.getPlayers().length
            && this.roundWinningPlayer.equals(roundResult.getRoundWinningPlayer());
    }
}
