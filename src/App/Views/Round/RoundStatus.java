package App.Views.Round;

import App.Models.Card.Card;
import App.Models.Player;
import App.Models.TrumpCategory;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 5/10/2016.
 */
public class RoundStatus {
    private final ArrayList<Player> players;
    private final Card currentCard;
    private final TrumpCategory currentTrumpCategory;
    private final Player currentPlayer;

    public RoundStatus(ArrayList<Player> players, Card currentCard, TrumpCategory currentTrumpCategory, Player currentPlayer) {
        this.players = players;
        this.currentCard = currentCard;
        this.currentTrumpCategory = currentTrumpCategory;
        this.currentPlayer = currentPlayer;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public TrumpCategory getCurrentTrumpCategory() {
        return currentTrumpCategory;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
}
