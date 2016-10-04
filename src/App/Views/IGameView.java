package App.Views;

import App.Models.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public interface IGameView {

    /**
     * Display game started
     */
    void gameStarted();

    /**
     * Display a winning player
     *
     * @param player The player who won
     */
    void winner(Player player);

    /**
     * Display all winners with their place
     *
     * @param winners The list of winners
     */
    void listWinners(ArrayList<Player> winners);
}
