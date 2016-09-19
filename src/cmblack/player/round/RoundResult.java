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
    public IPlayer getRoundWinningPlayer() {
        return roundWinningPlayer;
    }

    @Override
    public IPlayer[] getPlayersStillIn() {
        return playersStillIn;
    }

    @Override
    public IPlayer[] getPlayersWithNoCards() {
        return playersWithNoCards;
    }

    @Override
    public boolean equals(IRoundResult roundResult) {
        return this.playersStillIn.length == roundResult.getPlayersStillIn().length
            && this.playersWithNoCards.length == roundResult.getPlayersWithNoCards().length
            && this.roundWinningPlayer.equals(roundResult.getRoundWinningPlayer());
    }
}
