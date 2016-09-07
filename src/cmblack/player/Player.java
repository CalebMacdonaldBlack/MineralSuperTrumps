package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.deck.Deck;
import cmblack.game.Round;

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

    public void giveCard(Card card) {
        this.getCards().add(card);
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public abstract void haveTurn(Round round);

    public abstract void removeCard(Card card, Round round);
}
