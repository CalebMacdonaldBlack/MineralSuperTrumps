package App.Views.App;

import App.Models.Player;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public interface IAppView {

    /**
     * display menu
     */
    void showMenu();

    /**
     * farewell player
     */
    void farewell();

    void reShowMenu();
}
