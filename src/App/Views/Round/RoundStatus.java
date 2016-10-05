package App.Views.Round;

import App.Models.Card.Card;
import App.Models.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public class RoundStatus {
    private final ArrayList<Player> players;
    private final Card currentCard;

    public RoundStatus(ArrayList<Player> players, Card currentCard) {
        this.players = players;
        this.currentCard = currentCard;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
