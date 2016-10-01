package App.Models;

import App.Models.Card.Card;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Player {
    private final String name;
    private final PlayerType playerType;
    private final ArrayList<Card> cards;

    public Player(String name, PlayerType playerType ) {
        this.name = name;
        this.playerType = playerType;
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getName() {
        return name;
    }

    public enum PlayerType {
        BOT,
        HUMAN
    }
}
