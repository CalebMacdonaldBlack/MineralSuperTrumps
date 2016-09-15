package cmblack.player.round;

/**
 * Created by calebmacdonaldblack on 15/09/2016.
 */
public interface IObservableRound {
    void notifyRoundObservers();
    void addRoundObserver(IRoundObserver roundObserver);

    class FakeObservableRound implements IObservableRound {

        @Override
        public void notifyRoundObservers() {

        }

        @Override
        public void addRoundObserver(IRoundObserver roundObserver) {

        }
    }
}
