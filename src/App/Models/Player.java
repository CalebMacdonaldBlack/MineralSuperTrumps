package App.Models;

import App.App;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Player {
    private final String name;
    private final PlayerType playerType;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    public enum PlayerType {
        BOT,
        HUMAN
    }
}
