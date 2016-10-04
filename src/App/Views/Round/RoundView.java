package App.Views.Round;

import App.Controllers.RoundController;
import App.Models.Card.Card;
import App.Models.Player;
import App.Models.TrumpCategory;
import App.Views.ConsoleColor;

import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class RoundView implements IRoundView{
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Display round began
     */
    public void roundBegan() {
        System.out.println("ROUND STARTED");
    }

    /**
     * Gets category from human player
     * @param categories The categories to choose from
     * @param player The human player to select the categories
     */
    public void category(TrumpCategory[] categories, Player player, RoundController roundController) {
        displayCards(player);
        for (int i = 0; i < categories.length; i++) {
            System.out.println(i + ": " + categories[i].getText());
        }
        int input = -1;
        System.out.print("Option: ");
        while (input < 0 || input >= categories.length) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 0 || input >= categories.length) {
                    System.out.print("please enter a valid option:");
                }
            } catch (NumberFormatException e) {
                System.out.print("please enter a valid option:");
            }
        }
        roundController.selectCategory(categories[input]);
    }

    /**
     * Display all the players cards with colors showing ones that can be played
     * @param player The current human player
     * @param currentCard The current card
     * @param currentTrumpCategory The current trump category
     */
    private void displayCardsWithComarisonColor(Player player, Card currentCard, TrumpCategory currentTrumpCategory) {
        for (int i = 0; i < player.getCards().size(); i++) {
            if (!player.getCards().get(i).isBetterThan(currentCard, currentTrumpCategory) && !player.getCards().get(i).getCardType().equals(Card.CardType.TRUMP)) {
                System.out.println(ConsoleColor.colorText(i + ": \n" + player.getCards().get(i).toString(), ConsoleColor.ANSI_RED));
            } else {
                System.out.println(ConsoleColor.colorText(i + ": \n" + player.getCards().get(i).toString(), ConsoleColor.ANSI_GREEN));
            }
        }
    }

    /**
     * Displays all cards without color
     * @param player The human player
     */
    private void displayCards(Player player) {
        for (int i = 0; i < player.getCards().size(); i++) {
            System.out.println(player.getCards().get(i).toString());
        }
    }

    /**
     * Gets a card from the human player
     * @param player The human player
     * @param currentCard The current card
     * @param currentTrumpCategory The current trump category
     */
    public void card(Player player, Card currentCard, TrumpCategory currentTrumpCategory, RoundController roundController) {
        displayCardsWithComarisonColor(player, currentCard, currentTrumpCategory);

        System.out.println(player.getCards().size() + ": \n" + ConsoleColor.colorText("Don't play a card", ConsoleColor.ANSI_BLUE));

        System.out.println("\nCategory: " + currentTrumpCategory.getText() + "\ncurrentCard\n" + currentCard.toString());

        int input = -1;
        System.out.print("Option: ");
        while (input < 0 || input > player.getCards().size()) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 0 || input > player.getCards().size()) {
                    System.out.print("please enter a valid option:");
                } else if (input != player.getCards().size() && !player.getCards().get(input).isBetterThan(currentCard, currentTrumpCategory) && !player.getCards().get(input).getCardType().equals(Card.CardType.TRUMP)) {
                    System.out.println("please choose a card that is better (Green)");
                    input = -1;
                }
            } catch (NumberFormatException e) {
                System.out.print("please enter a valid option:");
            }
        }

        if (input == player.getCards().size()) {
            roundController.selectCard(currentCard);
        } else {
            roundController.selectCard(player.getCards().remove(input));
        }
    }

    /**
     * Display a category was selected
     * @param player The player who selected the category
     * @param currentTrumpCategory The trump category selected
     */
    public void categorySelected(Player player, TrumpCategory currentTrumpCategory) {
        System.out.println(ConsoleColor.colorText(player.getName() + " changed the category to " + currentTrumpCategory.getText(), ConsoleColor.ANSI_PURPLE));
    }

    /**
     * Display a card was selected
     * @param player The player who selected the card
     * @param currentCard The card selected by the player
     */
    public void cardSelected(Player player, Card currentCard) {
        System.out.println(ConsoleColor.colorText(player.getName() + " played the card " + currentCard.getTitle(), ConsoleColor.ANSI_PURPLE));
    }

    /**
     * Display player turn
     * @param player The player who's turn it is
     */
    public void playerTurn(Player player) {
        System.out.println(ConsoleColor.colorText("It is " + player.getName() + "'s turn.", ConsoleColor.ANSI_PURPLE));
    }

    /**
     * Display a removed player
     * @param player The player who got removed
     */
    public void playerRemoved(Player player) {
        System.out.println(ConsoleColor.colorText(player.getName() + " could not play a card and was removed", ConsoleColor.ANSI_PURPLE));
    }

    /**
     * Display there are no cards in the deck
     * @param player The player who tried to draw a card
     */
    public void noCardsLeftInDeck(Player player) {
        System.out.println(ConsoleColor.colorText(player.getName() + " could not draw a card because there are no cards left in the deck", ConsoleColor.ANSI_YELLOW));
    }

    /**
     * Display a player drawed a card
     * @param player The player who drew the card
     */
    public void drawCard(Player player) {
        System.out.println(ConsoleColor.colorText(player.getName() + " drew a card", ConsoleColor.ANSI_YELLOW));
    }

    /**
     * Display a trump card was selected
     * @param player The player who drew the card
     * @param currentCard The trump card that was played
     */
    public void trumpCardSelected(Player player, Card currentCard) {
        System.out.println(ConsoleColor.colorText(player.getName() + " played the trump card " + currentCard.getTitle(), ConsoleColor.ANSI_PURPLE));
    }

    /**
     * Display the round winner
     * @param player The player who won the round
     */
    public void roundWinner(Player player) {
        System.out.println(ConsoleColor.colorText(player.getName() + " won the round.", ConsoleColor.ANSI_BLUE));
    }
}
