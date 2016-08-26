package cmblack;

import cmblack.card.Card;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 26/08/2016.
 */
public abstract class Player {
    private final String playerName;
    private final ArrayList<Card> cards;

    protected Player(String playerName, ArrayList<Card> cards) {
        this.playerName = playerName;
        this.cards = cards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
