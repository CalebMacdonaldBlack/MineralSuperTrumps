package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class EmptyRoundResult implements IRoundResult {
    @Override
    public IPlayer roundWinningPlayer() {
        return new EmptyPlayer();
    }

    @Override
    public IPlayer[] playersWhoWon() {
        return new IPlayer[0];
    }

    @Override
    public boolean equals(IRoundResult roundResult) {
        return roundWinningPlayer().equals(roundResult.roundWinningPlayer())
            && playersWhoWon().length == 0;
    }
}
