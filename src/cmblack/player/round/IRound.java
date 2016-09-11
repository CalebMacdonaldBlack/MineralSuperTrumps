package cmblack.player.round;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRound {
    IRoundResult haveRound();
    class FakeRound implements IRound {

        @Override
        public IRoundResult haveRound() {
            return new IRoundResult.FakeRoundResult();
        }
    }
}
