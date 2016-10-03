package App.Views;

import App.Controllers.AppController;
import App.Models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class AppView extends JFrame{
    private final AppController appController;
    private final Scanner scanner = new Scanner(System.in);
    private final String ABOUT_TEXT = "Mineral Supertrumps is a game designed to help players learn about the properties and uses of common rock-forming materials. The pack consists of 54 mineral cards, and 6 \"supertrump\" cards. Each mineral card includes information about the mineral such as the generic chemical formula, the classification, crystal system, the geological environment where the mineral is commonly found or formed, as well as information in the five playing categories (or trumps) of hardness, specific gravity, cleavage, crustal abundance, and economic value. The first three playing categories relate to distinct physical properties of the mineral, while the last two categories rate the importance of the mineral in terms of abundance in the earths crust (continental and oceanic) and value to modern societies.";
    private final String OBJECTIVE_TEXT = "Objective: To be the first player to lose all of your cards";
    private final String INSTRUCTIONS_TEXT_1 = "1. 8 cards are dealt to each player. Each player can look at their cards, but should not show them to other players. The remaining cards are left in the deck";
    private final String INSTRUCTIONS_TEXT_2 = "2. A player is randomly chosen to go first and chooses a category. Afterwards they select a card to play";
    private final String INSTRUCTIONS_TEXT_3 = "3. The next player takes their turn. This player must play a mineral card that has a higher value in the playing category than the card played by the previous player. The game continues on with the next player";
    private final String INSTRUCTIONS_TEXT_4 = "4. If a player does not have any mineral cards that are of higher value for the specific category being played, then the player must pass and pick up one card from deck. The player then cannot player again until all other players have passed, or until another player plays a supertrump card to change the trump category, as described below. A player is allowed to pass even if they hold cards that could be played";
    private final String INSTRUCTIONS_TEXT_5 = "5. If the player has a supertrump card they may play this card at any of their turns. By playing  the supertrump card, the player changes the playing category or trump category according to the instructions on the supertrump card. At this stage, any player who had passed on the previos round is now able to play again.";
    private final String INSTRUCTIONS_TEXT_6 = "6. The game continues with players taking turns to play cards until all but one player has passed. The last player then gets to lead out the next round and chooses the category and card to play";
    private final String INSTRUCTIONS_TEXT_7 = "7. The winner of the game is the first player to lose all of the their cards. The game continues unitl all but one player (i.e., the loser) has lost their cards.";


    /**
     * Creates a new instance of appView
     *
     * @param gameController The controller with the callback methods
     */
    public AppView(AppController gameController) {
        super("Mineral Super Trumps");
        this.appController = gameController;
        this.setupWindow();
    }

    private void setupWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(1000, 1000);

        addTitle("Mineral Super Trumps", this);
        addSubTitle("Instructions", this);
        addMenuButtons();

        this.setVisible(true);
    }

    private void addMenuButtons() {
        JButton newGameButton = new JButton("New Game");
        JButton instructionsButton = new JButton("Instructions");
        JButton exitButton = new JButton("Exit");

        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.ipadx = 70;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.add(newGameButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(instructionsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panel.add(exitButton, gridBagConstraints);
        this.add(panel);

        instructionsButton.addActionListener(e -> {
          this.setVisible(false);

            JFrame instructionsJFrame = new JFrame("Mineral Super Trumps");
            instructionsJFrame.setLayout(new BoxLayout(instructionsJFrame.getContentPane(), BoxLayout.Y_AXIS));
            instructionsJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            instructionsJFrame.setSize(1000, 1000);
            addTitle("Mineral Super Trumps", instructionsJFrame);
            addSubTitle("Instructions", instructionsJFrame);

            JTextArea jTextArea1 = new JTextArea(ABOUT_TEXT);
            JTextArea jTextArea2 =new JTextArea(OBJECTIVE_TEXT);
            JTextArea jTextArea3 =new JTextArea(INSTRUCTIONS_TEXT_1);
            JTextArea jTextArea4 =new JTextArea(INSTRUCTIONS_TEXT_2);
            JTextArea jTextArea5 =new JTextArea(INSTRUCTIONS_TEXT_3);
            JTextArea jTextArea6 =new JTextArea(INSTRUCTIONS_TEXT_4);
            JTextArea jTextArea7 =new JTextArea(INSTRUCTIONS_TEXT_5);
            JTextArea jTextArea8 =new JTextArea(INSTRUCTIONS_TEXT_6);
            JTextArea jTextArea9 =new JTextArea(INSTRUCTIONS_TEXT_7);

            jTextArea1.setLineWrap(true);
            jTextArea2.setLineWrap(true);
            jTextArea3.setLineWrap(true);
            jTextArea4.setLineWrap(true);
            jTextArea5.setLineWrap(true);
            jTextArea6.setLineWrap(true);
            jTextArea7.setLineWrap(true);
            jTextArea8.setLineWrap(true);
            jTextArea9.setLineWrap(true);

            jTextArea1.setEditable(false);
            jTextArea2.setBackground(this.getBackground());

            instructionsJFrame.add(jTextArea1);
            instructionsJFrame.add(jTextArea2);
            instructionsJFrame.add(jTextArea3);
            instructionsJFrame.add(jTextArea4);
            instructionsJFrame.add(jTextArea5);
            instructionsJFrame.add(jTextArea6);
            instructionsJFrame.add(jTextArea7);
            instructionsJFrame.add(jTextArea8);
            instructionsJFrame.add(jTextArea9);

            JButton backButton = new JButton("Back to Menu");
            instructionsJFrame.setVisible(true);
            backButton.addActionListener(e1 -> {
                instructionsJFrame.setVisible(false);
                this.setVisible(true);
            });
            instructionsJFrame.add(backButton);
        });
    }

    private void addTitle(String titleText, JFrame jFrame) {
        JLabel title = new JLabel(titleText);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        jFrame.add(title);
        title.setFont(title.getFont().deriveFont(64f));
    }

    private void addSubTitle(String subTitleText, JFrame jFrame) {
        JLabel menuTitle = new JLabel(subTitleText);
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        jFrame.add(menuTitle);
        menuTitle.setFont(menuTitle.getFont().deriveFont(32f));
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
        appController.startGame(new App.Game(players));
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
}
