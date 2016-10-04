package App.Views.Game;

import App.Models.Player;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public class GameViewGui implements IGameView {

    @Override
    public void gameStarted() {

    }

    @Override
    public void winner(Player player) {
        JOptionPane.showMessageDialog(null, player.getName() + " has no cards left and was added as a winner!", "Mineral Super Trumps", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void listWinners(ArrayList<Player> winners) {
        String winnersNames = "Winners\n";
        for (int i = 0; i < winners.size(); i++) {
            switch (i) {
                case 0:
                    winnersNames += "\n1st: " + winners.get(i).getName();
                    break;
                case 1:
                    winnersNames += "\n2nd: " + winners.get(i).getName();
                    break;
                case 2:
                    winnersNames += "\n3rd: " + winners.get(i).getName();
                    break;
                default:
                    winnersNames += "\n" + (i + 1) + "th: " + winners.get(i).getName();
            }
        }

        JOptionPane.showMessageDialog(null, winnersNames, "Mineral Super Trumps", JOptionPane.INFORMATION_MESSAGE);
    }
}
