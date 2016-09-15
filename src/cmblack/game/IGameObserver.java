package cmblack.game;

/**
 * Created by calebmacdonaldblack on 14/09/2016.
 */
public interface IGameObserver {
    void notify(Game game);

    class FakeGameStateObserver implements IGameObserver {

        @Override
        public void notify(Game game) {

        }
    }
}
