package cmblack.game;

import cmblack.card.Card;
import cmblack.deck.Deck;
import cmblack.player.BotPlayer;
import cmblack.player.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 29/08/2016.
 */
public class Round {
    private final Deck deck;
    private final PlayerCircle playerCircle;
    private Card currentCard;
    private String category;
    private final ArrayList<Player> winningPlayers;

    public Round(Deck deck, PlayerCircle playerCircle, ArrayList<Player> winningPlayers) {
        this.deck = deck;
        this.playerCircle = playerCircle;
        this.winningPlayers = winningPlayers;
    }

    public void begin(){
        System.out.println("Starting Round\n==================");
        while(playerCircle.hasNext()){
            playerCircle.nextPlayer().haveTurn(this);
        }
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        if(this.currentCard != null){
            deck.addToDiscardedPile(this.currentCard);
        }
        this.currentCard = currentCard;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Deck getDeck() {
        return deck;
    }

    public PlayerCircle getPlayerCircle() {
        return playerCircle;
    }


    public void reset() {
        playerCircle.resetRoundUsingWinningPlayer();
        this.category = null;
        this.currentCard = null;
    }

    public void addWinner(Player player) {
        System.out.println(player.getPlayerName() + ": has no cards left and won! ");
        this.winningPlayers.add(player);
    }

    public ArrayList<Player> getWinningPlayers() {
        return winningPlayers;
    }
}
