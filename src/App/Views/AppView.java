package App.Views;

import App.Controllers.AppController;
import App.Models.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
    private final String ABOUT_TEXT = "<html>Mineral Supertrumps is a game designed to help players learn about the properties and uses of common rock-forming materials. The pack consists of 54 mineral cards, and 6 \"supertrump\" cards. Each mineral card includes information about the mineral such as the generic chemical formula, the classification, crystal system, the geological environment where the mineral is commonly found or formed, as well as information in the five playing categories (or trumps) of hardness, specific gravity, cleavage, crustal abundance, and economic value. The first three playing categories relate to distinct physical properties of the mineral, while the last two categories rate the importance of the mineral in terms of abundance in the earths crust (continental and oceanic) and value to modern societies.</html>";
    private final String OBJECTIVE_TEXT = "<html>Objective: To be the first player to lose all of your cards</html>";
    private final String INSTRUCTIONS_TEXT_1 = "<html>1. 8 cards are dealt to each player. Each player can look at their cards, but should not show them to other players. The remaining cards are left in the deck</html>";
    private final String INSTRUCTIONS_TEXT_2 = "<html>2. A player is randomly chosen to go first and chooses a category. Afterwards they select a card to play</html>";
    private final String INSTRUCTIONS_TEXT_3 = "<html>3. The next player takes their turn. This player must play a mineral card that has a higher value in the playing category than the card played by the previous player. The game continues on with the next player</html>";
    private final String INSTRUCTIONS_TEXT_4 = "<html>4. If a player does not have any mineral cards that are of higher value for the specific category being played, then the player must pass and pick up one card from deck. The player then cannot player again until all other players have passed, or until another player plays a supertrump card to change the trump category, as described below. A player is allowed to pass even if they hold cards that could be played</html>";
    private final String INSTRUCTIONS_TEXT_5 = "<html>5. If the player has a supertrump card they may play this card at any of their turns. By playing  the supertrump card, the player changes the playing category or trump category according to the instructions on the supertrump card. At this stage, any player who had passed on the previos round is now able to play again.</html>";
    private final String INSTRUCTIONS_TEXT_6 = "<html>6. The game continues with players taking turns to play cards until all but one player has passed. The last player then gets to lead out the next round and chooses the category and card to play</html>";
    private final String INSTRUCTIONS_TEXT_7 = "<html>7. The winner of the game is the first player to lose all of the their cards. The game continues unitl all but one player (i.e., the loser) has lost their cards.</html>";

    /**
     * Creates a new instance of appView
     *
     * @param gameController The controller with the callback methods
     */
    public AppView(AppController gameController) {
        super("Mineral Super Trumps");
        this.appController = gameController;
        this.showMenuGui();
    }

    private void showMenuGui() {

        setUpWindow(this);
        addTitle("Mineral Super Trumps", this);
        addSubTitle("Instructions", this);
        addMenuButtons();

        this.setVisible(true);
    }

    private void setUpWindow(JFrame frame){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(1000, 1200);
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
        newGameButton.addActionListener(e -> {
            openPlayersGui();
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(instructionsButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panel.add(exitButton, gridBagConstraints);
        exitButton.addActionListener(e -> {
            System.exit(1);
        });
        this.add(panel);

        instructionsButton.addActionListener(e -> {
            showInstructions();
        });
    }

    private void openPlayersGui() {
        this.setVisible(false);
        JFrame addPlayersJFrame = new JFrame("Mineral Super Trumps");
        setUpWindow(addPlayersJFrame);
        addTitle("Mineral Super Trumps", addPlayersJFrame);
        addSubTitle("Add Players", addPlayersJFrame);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JTextField yourName = new JTextField("Human");
        JTextField bot1Name = new JTextField("bot 1");
        JTextField bot2Name = new JTextField("bot 2");
        JTextField bot3Name = new JTextField("bot 3");
        JTextField bot4Name = new JTextField("bot 4");

        panel.add(new JLabel("Your name: "), modifiedGridBagConstraint(0,0, gridBagConstraints));
        panel.add(yourName, modifiedGridBagConstraint(1,0, gridBagConstraints));
        panel.add(new JLabel("Bot 1: "), modifiedGridBagConstraint(0,1, gridBagConstraints));
        panel.add(bot1Name, modifiedGridBagConstraint(1,1, gridBagConstraints));
        panel.add(new JLabel("Bot 2: "), modifiedGridBagConstraint(0,2, gridBagConstraints));
        panel.add(bot2Name, modifiedGridBagConstraint(1,2, gridBagConstraints));
        panel.add(new JLabel("Bot 3: "), modifiedGridBagConstraint(0,3, gridBagConstraints));
        panel.add(bot3Name, modifiedGridBagConstraint(1,3, gridBagConstraints));
        panel.add(new JLabel("Bot 4: "), modifiedGridBagConstraint(0,4, gridBagConstraints));
        panel.add(bot4Name, modifiedGridBagConstraint(1,4, gridBagConstraints));
        addPlayersJFrame.add(panel);
        JButton startGameButton = new JButton("Start Game");
        addPlayersJFrame.add(startGameButton);
        startGameButton.addActionListener(e -> {
            startGame(yourName, bot1Name, bot2Name, bot3Name, bot4Name);
            addPlayersJFrame.setVisible(false);
        });
        addPlayersJFrame.setVisible(true);
    }

    private void startGame(JTextField yourName, JTextField bot1Name, JTextField bot2Name, JTextField bot3Name, JTextField bot4Name) {
        ArrayList<Player> players = new ArrayList();
        players.add(new Player(yourName.getText(), Player.PlayerType.HUMAN));
        players.add(new Player(bot1Name.getText(), Player.PlayerType.BOT));
        players.add(new Player(bot2Name.getText(), Player.PlayerType.BOT));
        players.add(new Player(bot3Name.getText(), Player.PlayerType.BOT));
        players.add(new Player(bot4Name.getText(), Player.PlayerType.BOT));
        appController.startGame(new App.Game(players));
    }

    private GridBagConstraints modifiedGridBagConstraint(int x, int y, GridBagConstraints gridBagConstraints) {
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 5;
        return gridBagConstraints;
    }

    private void showInstructions() {
        this.setVisible(false);

        JFrame instructionsJFrame = new JFrame("Mineral Super Trumps");
        setUpWindow(instructionsJFrame);
        addTitle("Mineral Super Trumps", instructionsJFrame);
        addSubTitle("Instructions", instructionsJFrame);

        instructionsJFrame.add(jLabelWithModifers(ABOUT_TEXT));
        instructionsJFrame.add(jLabelWithModifers(OBJECTIVE_TEXT));
        instructionsJFrame.add(jLabelWithModifers(INSTRUCTIONS_TEXT_1));
        instructionsJFrame.add(jLabelWithModifers(INSTRUCTIONS_TEXT_2));
        instructionsJFrame.add(jLabelWithModifers(INSTRUCTIONS_TEXT_3));
        instructionsJFrame.add(jLabelWithModifers(INSTRUCTIONS_TEXT_4));
        instructionsJFrame.add(jLabelWithModifers(INSTRUCTIONS_TEXT_5));
        instructionsJFrame.add(jLabelWithModifers(INSTRUCTIONS_TEXT_6));
        instructionsJFrame.add(jLabelWithModifers(INSTRUCTIONS_TEXT_7));

        JButton backButton = new JButton("Back to Menu");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionsJFrame.setVisible(true);
        backButton.addActionListener(e1 -> {
            instructionsJFrame.setVisible(false);
            this.setVisible(true);
        });
        instructionsJFrame.add(backButton);
    }

    private JComponent componentWithMargin(JComponent component){
        Border border = component.getBorder();
        Border margin = new EmptyBorder(20,100,0,100);
        component.setBorder(new CompoundBorder(border, margin));
        return component;
    }

    private Component jLabelWithModifers(String about_text) {
        JLabel jLabel = new JLabel(about_text);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return componentWithMargin(jLabel);
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
