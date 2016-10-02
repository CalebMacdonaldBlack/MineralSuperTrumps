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

    /**
     * Creates a new instance of player
     *
     * @param name       The players name
     * @param playerType The type of player. Bot or Human
     */
    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
        this.cards = new ArrayList<>();
    }

    /**
     * Gets the players cards in their hand
     *
     * @return List of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Gets the player's type
     *
     * @return Player type enum
     */
    public PlayerType getPlayerType() {
        return playerType;
    }

    /**
     * Gets the player's name
     *
     * @return Player's name
     */
    public String getName() {
        return name;
    }

    public enum PlayerType {
        BOT,
        HUMAN
    }
}
