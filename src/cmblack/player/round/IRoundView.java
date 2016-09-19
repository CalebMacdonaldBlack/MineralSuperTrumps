package cmblack.player.round;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public interface IRoundView {
    void update(IRound round);

    class FakeRoundView implements IRoundView {

        @Override
        public void update(IRound round) {

        }
    }
}
