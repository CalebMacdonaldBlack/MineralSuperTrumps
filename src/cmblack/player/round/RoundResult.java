package cmblack.player.round;

import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResult implements IRoundResult {
    private final IPlayer[] playersWhoWon, playersLeft;
    private final IPlayer roundWinningPlayer;

    public RoundResult(IPlayer[] playersWhoWon, IPlayer[] playersLeft, IPlayer roundWinningPlayer) {
        this.playersWhoWon = playersWhoWon;
        this.playersLeft = playersLeft;
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

    @Override
    public IPlayer[] playersLeft() {
        return this.playersLeft;
    }
}
