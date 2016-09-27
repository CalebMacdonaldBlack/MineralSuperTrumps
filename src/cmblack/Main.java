package cmblack;

import cmblack.deck.IDeck;
import cmblack.player.BotPlayer;
import cmblack.player.HumanPlayer;
import cmblack.player.IPlayer;
import cmblack.player.playerhand.PlayerHand;
import cmblack.player.round.PlayerGroup;
import cmblack.view.IView;
import cmblack.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        printMenu();
        String choice = scanner.nextLine();
        while(true){
            while(!choice.equals("0") && !choice.equals("1")){
                System.out.println("Please enter a valid option");
                printMenu();
            }
            if(choice.equals("1")){
                break;
            } else {
               startGame();
                printMenu();
                choice = scanner.nextLine();
            }
        }
        System.out.println("goodbye");




    }

    private static void startGame() {
        List<IPlayer> players = new ArrayList<>();
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        while (name.equals("")){
            System.out.print("Please enter a valid name: ");
            name = scanner.nextLine();
        }
        players.add(new HumanPlayer(name, new PlayerHand()));

        System.out.println("please enter bot names. Type 'done' when finished");
        for(int i=1;i<5;i++){
            System.out.print("bot " + i + " name: ");
            String botName = scanner.nextLine();
            while(botName.equals("done") && players.size() <= 1){
                System.out.println("Please enter at least one bot!");
                botName = scanner.nextLine();
            }
            if(botName.equals("done") && players.size() > 1){
                break;
            }
            while (botName.equals("")){
                System.out.print("Please enter a valid name: ");
                botName = scanner.nextLine();
            }
            players.add(new BotPlayer(botName, new PlayerHand()));
        }

        IGame game = new Game(new IDeck.FakeDeck(), new PlayerGroup(players.toArray(new IPlayer[players.size()])), new View());
        List<IPlayer> winners = game.startGame();

        for(int i=1;i<=winners.size();i++){
            switch (i){
                case 1:
                    System.out.println("1st: " + winners.get(i - 1).getName());
                    break;
                case 2:
                    System.out.println("2nd: " + winners.get(i - 1).getName());
                    break;
                case 3:
                    System.out.println("3rd: " + winners.get(i - 1).getName());
                    break;
                default:
                    System.out.println(i + "th: " + winners.get(i - 1).getName());
            }
        }
    }

    private static void printMenu() {
        System.out.print("Menu:\n0:\tnew game\n1:\tquit\n\nOption: ");

    }
}
