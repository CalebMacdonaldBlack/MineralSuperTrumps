package cmblack.game;

/**
 * Created by calebmacdonaldblack on 14/09/2016.
 */
public interface IGameObserver {
    void update(Game game);

    class FakeGameStateObserver implements IGameObserver {

        @Override
        public void update(Game game) {

        }
    }
}
