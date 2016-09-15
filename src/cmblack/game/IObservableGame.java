package cmblack.game;

/**
 * Created by calebmacdonaldblack on 14/09/2016.
 */
public interface IObservableGame {
    void notifyGameObservers();

    void addGameObserver(IGameObserver gameObserver);

    class FakeObservableGame implements IObservableGame {

        @Override
        public void notifyGameObservers() {

        }

        @Override
        public void addGameObserver(IGameObserver gameObserver) {

        }
    }
}
