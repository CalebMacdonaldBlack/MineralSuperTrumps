import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Game implements GameController{
    private final ArrayList<Player> players;
    private final GameView gameView;

    public Game(ArrayList<Player> players) {
        this.players = players;
        this.gameView = new GameView();
    }

    public void begin() {
        gameView.gameStarted();
    }
}
