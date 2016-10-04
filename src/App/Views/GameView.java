package App.Views;

import App.Models.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class GameView implements IGameView{

    /**
     * Display game started
     */
    public void gameStarted() {
        System.out.println("\nGAME STARTED\n");
    }

    /**
     * Display a winning player
     *
     * @param player The player who won
     */
    public void winner(Player player) {
        System.out.println(ConsoleColor.colorText(player.getName() + " has no cards and was added as a winner!", ConsoleColor.ANSI_CYAN));
    }

    /**
     * Display all winners with their place
     *
     * @param winners The list of winners
     */
    public void listWinners(ArrayList<Player> winners) {
        System.out.println("Winners!");
        for (int i = 0; i < winners.size(); i++) {
            switch (i) {
                case 0:
                    System.out.println("1st: " + winners.get(i).getName());
                    break;
                case 1:
                    System.out.println("2nd: " + winners.get(i).getName());
                    break;
                case 2:
                    System.out.println("3rd: " + winners.get(i).getName());
                    break;
                default:
                    System.out.println((i + 1) + "th: " + winners.get(i).getName());
            }
        }
    }
}
