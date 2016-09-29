package App.Views;

import App.Controllers.RoundController;
import App.Models.Card.Card;
import App.Models.Player;
import App.Models.TrumpCategory;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class RoundView {
    private final RoundController roundController;
    private final Scanner scanner = new Scanner(System.in);

    public RoundView(RoundController roundController){
        this.roundController = roundController;
    }

    public void roundBegan() {
        System.out.println("ROUND STARTED");
    }

    public void category(TrumpCategory[] categories) {
        for(int i=0;i<categories.length;i++){
            System.out.println(i + ": " + categories[i].getText());
        }
        int input = -1;
        System.out.print("Option: ");
        while (input < 0 || input >= categories.length) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if(input < 0 || input >= categories.length){
                    System.out.print("please enter a valid option:");
                }
            } catch (NumberFormatException e) {
                System.out.print("please enter a valid option:");
            }
        }
        roundController.selectCategory(categories[input]);
    }

    public void card(Player player, Card currentCard, TrumpCategory currentTrumpCategory) {
        for(int i=0;i<player.getCards().size();i++){
            if(!player.getCards().get(i).isBetterThan(currentCard, currentTrumpCategory) && !player.getCards().get(i).getCardType().equals(Card.CardType.TRUMP)){
                System.out.println(ConsoleColor.colorText(i + ": \n" + player.getCards().get(i).toString(), ConsoleColor.ANSI_RED));
            } else {
                System.out.println(ConsoleColor.colorText(i + ": \n" + player.getCards().get(i).toString(), ConsoleColor.ANSI_BLUE));
            }
        }

        System.out.println(player.getCards().size() + ": \n" + ConsoleColor.colorText("Don't play a card", ConsoleColor.ANSI_BLUE));

        int input = -1;
        System.out.print("Option: ");
        while (input < 0 || input >= player.getCards().size()) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if(input < 0 || input > player.getCards().size()){
                    System.out.print("please enter a valid option:");
                }else if(input != player.getCards().size() && !player.getCards().get(input).isBetterThan(currentCard, currentTrumpCategory) && player.getCards().get(input).getCardType().equals(Card.CardType.TRUMP)){
                    System.out.println("please choose a card that is better (blue)");
                    input = -1;
                }
            } catch (NumberFormatException e) {
                System.out.print("please enter a valid option:");
            }
        }

        if(input == player.getCards().size()){
            roundController.selectCard(currentCard);
        } else {
            roundController.selectCard(player.getCards().remove(input));
        }
    }

    public void categorySelected(Player player, TrumpCategory currentTrumpCategory) {
        System.out.println(ConsoleColor.colorText(player.getName() + " changed the category to " + currentTrumpCategory.getText(), ConsoleColor.ANSI_PURPLE));
    }

    public void cardSelected(Player player, Card currentCard) {
        System.out.println(ConsoleColor.colorText(player.getName() + " played the card " + currentCard.getTitle(), ConsoleColor.ANSI_PURPLE));
    }
}
