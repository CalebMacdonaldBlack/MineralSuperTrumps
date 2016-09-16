package cmblack.player.round;

import cmblack.player.IPlayer;
import cmblack.player.round.turn.IPlayerTurnResult;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRound {
    IRoundResult haveRound();
    RoundState getRoundState();
    IPlayer getCurrentPlayer();
    IPlayerTurnResult getPlayerTurnResult();
    ArrayList<IPlayer> getWinners();
    boolean equals(IRound round);

    class FakeRound implements IRound {

        @Override
        public IRoundResult haveRound() {
            return new IRoundResult.FakeRoundResult();
        }

        @Override
        public RoundState getRoundState() {
            return RoundState.START;
        }

        @Override
        public IPlayer getCurrentPlayer() {
            return new IPlayer.FakePlayer();
        }

        @Override
        public IPlayerTurnResult getPlayerTurnResult() {
            return new IPlayerTurnResult.FakePlayerTurnResult();
        }

        @Override
        public ArrayList<IPlayer> getWinners() {
            return new ArrayList<>();
        }

        @Override
        public boolean equals(IRound round) {
            throw new NotImplementedException();
        }
    }
}
