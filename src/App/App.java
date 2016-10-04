package App;

import App.Controllers.AppController;
import App.Views.AppView;
import App.Views.AppViewGui;
import App.Views.IAppView;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class App implements AppController {
    private final IAppView appView;

    /**
     * Creates a new instance of app
     */
    public App(){
//        this.appView = new AppView(this);
        this.appView = new AppViewGui(this);
    }

    /**
     * shows the menu
     */
    public void menu() {
        appView.showMenu();
    }

    /**
     * View Callback method for starting a game
     * @param game The game instance
     */
    @Override
    public void startGame(Game game) {
        game.begin();
        this.menu();
    }

    /**
     * View callback method for quitting a game
     */
    @Override
    public void quitGame() {
        this.appView.farewell();
    }
}
