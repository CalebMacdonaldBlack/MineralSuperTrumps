package cmblack.player.round;

import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResult implements IRoundResult {
    private final IPlayer[] playersWhoWon;
    private final IPlayer roundWinningPlayer;

    public RoundResult(IPlayer[] playersWhoWon, IPlayer roundWinningPlayer) {
        this.playersWhoWon = playersWhoWon;
        this.roundWinningPlayer = roundWinningPlayer;
    }

    @Override
    public IPlayer roundWinningPlayer() {
        return this.roundWinningPlayer;
    }

    @Override
    public IPlayer[] playersWhoWon() {
        return this.playersWhoWon;
    }
}
