package cmblack.player;

import cmblack.card.Card;
import cmblack.card.PlayCard;
import cmblack.category.Category;
import cmblack.deck.Deck;

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

    public void giveCard(Card card){
        this.cards.add(card);
    }

    public int getCountOfCards(){
        return this.cards.size();
    }

    public abstract PlayCard getCardToPlay(String categoryName, PlayCard currentCard, Deck deck, ArrayList<Player> playersInCurrentTurn);
}
