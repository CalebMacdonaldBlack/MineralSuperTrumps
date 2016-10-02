package App.Controllers;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public interface AppController {

    /**
     * Starts a game
     *
     * @param game The game instance
     */
    void startGame(App.Game game);

    /**
     * Fairwells and ends a game
     */
    void quitGame();
}
