package App.Views;

import App.App;
import App.Controllers.AppController;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class AppView {
    private final AppController appController;
    private final Scanner scanner = new Scanner(System.in);

    public AppView(AppController gameController) {
        this.appController = gameController;
    }


    public void showMenu(){
        System.out.print("0:\tNew App.Game\n1:\tQuit\n\nOption: ");

        String input = scanner.nextLine();
        while(!input.equals("0") && input.equals("1")){
            System.out.print("Please select a valid option (0 or 1): ");
            input = scanner.nextLine();
        }
        if(input.equals("0")){
            this.askForPlayers();
        } else {
            appController.quitGame();
        }

    }

    private void askForPlayers() {
        ArrayList<App.Player> players = new ArrayList<>();
        players.add(askForHumanPlayer());
        for(int count=0;count<4; count++){
            players.add(askForBot(count));
        }
        appController.startGame(new App.Game(players));
    }

    private App.Player askForBot(int count) {
        System.out.print("Please enter name for bot " + count + " :");
        String name = scanner.nextLine();
        while(name.equals("")){
            System.out.print("please enter a valid name for the bot: ");
            name = scanner.nextLine();
        }
        return new App.Player(name, App.Player.PlayerType.BOT);
    }

    private App.Player askForHumanPlayer() {

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        while(name.equals("")){
            System.out.print("please enter a name: ");
            name = scanner.nextLine();
        }
        return new App.Player(name, App.Player.PlayerType.HUMAN);
    }

    public void farewell() {
        System.out.println("Goodbye");
    }
}
