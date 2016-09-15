package cmblack.player.round;

/**
 * Created by calebmacdonaldblack on 15/09/2016.
 */
public interface IRoundObserver {
    void update(IRound round);

    class FakeRoundObserver implements IRoundObserver{

        @Override
        public void update(IRound round) {

        }
    }
}
