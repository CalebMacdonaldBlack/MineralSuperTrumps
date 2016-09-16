package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import cmblack.player.round.turn.EmptyTurnResult;
import cmblack.player.round.turn.IPlayerTurnResult;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public class EmptyRound implements IRound {
    @Override
    public IRoundResult haveRound() {
        return new EmptyRoundResult();
    }

    @Override
    public RoundState getRoundState() {
        return RoundState.START;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return new EmptyPlayer();
    }

    @Override
    public IPlayerTurnResult getPlayerTurnResult() {
        return new EmptyTurnResult();
    }

    @Override
    public ArrayList<IPlayer> getWinners() {
        return new ArrayList<>();
    }

    @Override
    public boolean equals(IRound round) {
        return getRoundState().equals(round.getRoundState())
            && getCurrentPlayer().equals(round.getCurrentPlayer())
            && getPlayerTurnResult().equals(round.getPlayerTurnResult())
            && getWinners().size() == 0;
    }
}
