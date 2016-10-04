package App.Views.Round;

import App.Models.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public class RoundStatus {
    private final ArrayList<Player> players;

    public RoundStatus(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
