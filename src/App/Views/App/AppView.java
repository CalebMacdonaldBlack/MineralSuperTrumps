package App.Views.App;

import App.Controllers.AppController;
import App.Models.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class AppView extends JFrame implements IAppView{
    private final AppController appController;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Creates a new instance of appView
     *
     * @param gameController The controller with the callback methods
     */
    public AppView(AppController gameController) {
        super("Mineral Super Trumps");
        this.appController = gameController;
    }


    /**
     * display menu
     */
    public void showMenu() {
        System.out.print("\n0:\tNew Game\n1:\tQuit\n\nOption: ");


        String input = scanner.nextLine();
        while (!input.equals("0") && !input.equals("1")) {
            System.out.print("Please select a valid option (0 or 1): ");
            input = scanner.nextLine();
        }
        if (input.equals("0")) {
            this.askForPlayers();
        } else {
            appController.quitGame();
        }

    }

    /**
     * Ask to enter players
     */
    private void askForPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(askForHumanPlayer());
        for (int count = 0; count < 4; count++) {
            players.add(askForBot(count));
        }
        appController.startGame(new App.Game(players, players.get(0)));
    }

    /**
     * Create bot with name
     *
     * @param index The index of the bot
     * @return The created bot
     */
    private Player askForBot(int index) {
        System.out.print("Please enter name for bot " + index + " :");
        String name = scanner.nextLine();
        while (name.equals("")) {
            System.out.print("please enter a valid name for the bot: ");
            name = scanner.nextLine();
        }
        return new Player(name, Player.PlayerType.BOT);
    }

    /**
     * Create human player with name
     *
     * @return The created player
     */
    private Player askForHumanPlayer() {

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        while (name.equals("")) {
            System.out.print("please enter a name: ");
            name = scanner.nextLine();
        }
        return new Player(name, Player.PlayerType.HUMAN);
    }

    /**
     * farewell player
     */
    public void farewell() {
        System.out.println("Goodbye");
    }

    @Override
    public void reShowMenu() {

    }
}
