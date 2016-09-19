package cmblack.player.round;

import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResult implements IRoundResult {

    private final IPlayer roundWinningPlayer;
    private final IPlayer[] playersStillIn;
    private final IPlayer[] playersWithNoCards;

    public RoundResult(IPlayer roundWinningPlayer, IPlayer[] playersStillIn, IPlayer[] playersWithNoCards) {
        this.roundWinningPlayer = roundWinningPlayer;
        this.playersStillIn = playersStillIn;
        this.playersWithNoCards = playersWithNoCards;
    }

    @Override
    public IPlayer roundWinningPlayer() {
        return null;
    }

    @Override
    public IPlayer[] playersStillIn() {
        return new IPlayer[0];
    }

    @Override
    public IPlayer[] playersWithNoCards() {
        return new IPlayer[0];
    }

    @Override
    public boolean equals(IRoundResult roundResult) {
        return false;
    }
}
