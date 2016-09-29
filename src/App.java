/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class App implements AppController {
    private final AppView appView;

    public App(){
        this.appView = new AppView(this);
    }

    public void menu() {
        appView.showMenu();
    }

    @Override
    public void startGame(Game game) {
        game.begin();
    }

    @Override
    public void quitGame() {
        this.appView.farewell();
    }
}
