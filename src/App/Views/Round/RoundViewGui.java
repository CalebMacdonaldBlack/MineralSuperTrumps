package App.Views.Round;

import App.Controllers.RoundController;
import App.Models.Card.Card;
import App.Models.Player;
import App.Models.TrumpCategory;
import App.Views.ConsoleColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public class RoundViewGui implements IRoundView {

    private final JFrame roundJFrame;
    private JPanel playersPanel = new JPanel();
    private JLabel currentCardLabel = new JLabel();
    private JLabel currentCategoryLabel = new JLabel();
    private JLabel currentPlayerLabel = new JLabel();
    private JScrollPane jScrollPane;

    public RoundViewGui(){
        this.roundJFrame = new JFrame("Mineral Super Trumps");
        this.setUpWindow(roundJFrame);
    }

    private void setUpWindow(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        addTitle("Mineral Super Trumps", frame);
        addPlayersPanel();
        addCurrentCard("slide66.jpg");
        addLabelBox(currentCategoryLabel, "<html><font color='white'><center>Category<br>Specific Gravity</center></font></html>", Color.red, createGridBagConstraints(2, 1, 1, 1));
        addHumansCards();
        addLabelBox(currentPlayerLabel, "<html><font color='white'><center>Current Player<br>Dave</center></font></html>", Color.black, createGridBagConstraints(3, 1, 1, 1));
    }

    private void addHumansCards() {
        JPanel panel = new JPanel();

        for(int i=0;i<6;i++){
            JButton card = new JButton();
            card.setBorder(new LineBorder(Color.white, 25));
            try {
                card.setIcon(new ImageIcon(getScaledImage(ImageIO.read(new File("images/slide66.jpg")), 171, 239)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            panel.add(card);
        }
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        jScrollPane = new JScrollPane(panel);
        jScrollPane.setPreferredSize(new Dimension(1700, 400));
        jScrollPane.setBackground(Color.white);
        roundJFrame.add(jScrollPane, createGridBagConstraints(0,2,4,1));
    }

    private void addLabelBox(JLabel label, String text, Color color, GridBagConstraints gridBagConstraints) {
        label.setText(text);
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), 20));
        label.setBorder(new LineBorder(color, 50));
        label.setBackground(color);
        label.setOpaque(true);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        roundJFrame.add(label, gridBagConstraints);
    }

    private void addCurrentCard(String fileName) {
        try {
            currentCardLabel.setIcon(new ImageIcon(getScaledImage(ImageIO.read(new File("images/" + fileName)), 171, 239)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        roundJFrame.add(currentCardLabel, createGridBagConstraints(1, 1 , 1, 1));
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    private void addPlayersPanel() {
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        roundJFrame.add(playersPanel, createGridBagConstraints(0, 1, 1,1));
        for(int i=0;i<5;i++){
            playersPanel.add(new JLabel("Player " + 1));
        }
    }

    private void updatePlayersPanel(ArrayList<Player> players){
        for(int i=0;i<5;i++){
            try {
                Player player = players.get(i);
                ((JLabel) playersPanel.getComponent(i)).setText(player.getName() + " - Cards: " + player.getCards().size());
            }catch(IndexOutOfBoundsException e){
                ((JLabel) playersPanel.getComponent(i)).setText("");
            }
        }
    }

    private void addTitle(String titleText, JFrame jFrame) {
        JLabel title = new JLabel(titleText);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        jFrame.add(title, createGridBagConstraints(0, 0, 4, 1));
        title.setFont(title.getFont().deriveFont(64f));
    }

    private GridBagConstraints createGridBagConstraints(int x, int y, int width, int height){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
        return gridBagConstraints;
    }

    @Override
    public void roundBegan(RoundStatus roundStatus) {
        System.out.println("ROUND BEGAN");
        updateView(roundStatus);
    }

    private void updateView(RoundStatus roundStatus){
        updatePlayersPanel(roundStatus.getPlayers());
        updateCurrentCard(roundStatus.getCurrentCard());
        updateCurrentCategory(roundStatus.getCurrentTrumpCategory());
        updateCurrentPlayer(roundStatus.getCurrentPlayer());
    }

    private void updateCurrentPlayer(Player currentPlayer) {
        currentPlayerLabel.setText("<html><font color='white'><center>Current Player<br>"+currentPlayer.getName()+"</center></font></html>");
    }

    private void updateCurrentCategory(TrumpCategory currentTrumpCategory) {
        if(currentTrumpCategory != null)
        this.currentCategoryLabel.setText("<html><font color='white'><center>Category<br>"+ currentTrumpCategory.getText()+"</center></font></html>");
    }

    private void updateCurrentCard(Card currentCard) {
        this.addCurrentCard(currentCard.getFileName());
    }

    @Override
    public void category(TrumpCategory[] categories, Player player, RoundController roundController) {
        for (int i = 0; i < categories.length; i++) {
            System.out.println(i + ": " + categories[i].getText());
        }
        int input = -1;
        System.out.print("Option: ");
        while (input < 0 || input >= categories.length) {
            try {
                input = Integer.parseInt(new Scanner(System.in).nextLine());
                if (input < 0 || input >= categories.length) {
                    System.out.print("please enter a valid option:");
                }
            } catch (NumberFormatException e) {
                System.out.print("please enter a valid option:");
            }
        }
        roundController.selectCategory(categories[input]);
    }

    @Override
    public void card(Player player, Card currentCard, TrumpCategory currentTrumpCategory, RoundController roundController) {
        updateHumansCards(player, roundController);
        for(Card card: player.getCards()){
            System.out.println(card.toString());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(player.getCards().size() + ": \n" + ConsoleColor.colorText("Don't play a card", ConsoleColor.ANSI_BLUE));

        System.out.println("\nCategory: " + currentTrumpCategory.getText() + "\ncurrentCard\n" + currentCard.toString());

        int input = -1;
        System.out.print("Option: ");
        while (input < 0 || input > player.getCards().size()) {
            try {
                input = Integer.parseInt(new Scanner(System.in).nextLine());
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

    private void updateHumansCards(Player player, RoundController roundController) {
        JPanel panel = new JPanel();

        for(Card c: player.getCards()){
            JButton card = new JButton();
            card.setBorder(new LineBorder(Color.white, 25));
            try {
                card.setIcon(new ImageIcon(getScaledImage(ImageIO.read(new File("images/" + c.getFileName())), 171, 239)));
                card.addActionListener(e -> {
                    System.out.println(c.getTitle());
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            panel.add(card);
        }
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        jScrollPane.setViewportView(panel);

        roundJFrame.revalidate();
        roundJFrame.repaint();
    }

    @Override
    public void categorySelected(Player player, TrumpCategory currentTrumpCategory, RoundStatus roundStatus) {
        updateView(roundStatus);
    }

    @Override
    public void cardSelected(Player player, Card currentCard, RoundStatus roundStatus) {
        updateView(roundStatus);
    }

    @Override
    public void playerTurn(Player player, RoundStatus roundStatus) {
        updateView(roundStatus);

    }

    @Override
    public void playerRemoved(Player player) {

    }

    @Override
    public void noCardsLeftInDeck(Player player) {

    }

    @Override
    public void drawCard(Player player) {

    }

    @Override
    public void trumpCardSelected(Player player, Card currentCard) {

    }

    @Override
    public void roundWinner(Player player) {

    }
}
