package cmblack.game;

import cmblack.card.Card;
import cmblack.card.TrumpCard;
import cmblack.deck.Deck;
import cmblack.player.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 29/08/2016.
 */
public class Round {
    private final Player[] players;
    private final Deck deck;

    public Round(Player[] players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }


    public void begin() {
        System.out.println("=========================");
        System.out.println("Starting a new round\n");
        ArrayList<Player> playersInRound = this.getPlayersAsList();
        startRound(playersInRound);
    }

    //TODO break up and unit test
    public void startRound(ArrayList<Player> playersInRound) {

        Card card = null;
        String category = null;
        while (playersInRound.size() > 1) {
            ArrayList<Player> currentRotation = new ArrayList<>(playersInRound);
            System.out.println("=========================");
            System.out.println("Starting a new rotation\n");
            for (Player player : currentRotation) {
                if (playersInRound.size() == 1) {
                    System.out.println("Round Winning Player: " + playersInRound.get(0).getPlayerName());
                    playerGoesFirstNextRound(player, playersInRound);
                    break;
                }

                if (category == null) {
                    System.out.println(player.getPlayerName() + " is selecting a category");
                    category = player.chooseCategory();
                    System.out.println(player.getPlayerName() + " selected  " + category + " as the category");
                }

                Card cardToPlay = player.getCardToPlay(category, card, deck);

                if (cardToPlay == null) {
                    System.out.println(player.getPlayerName() + " could not play a card and was removed from the game.");
                    playersInRound.remove(player);
                    player.giveCard(this.deck.takeCard());
                } else if (cardToPlay instanceof TrumpCard) {
                    System.out.println(player.getPlayerName() + "played the trump card " + card.getTitle());
                    category = player.chooseCategory(((TrumpCard) cardToPlay).getCategories());
                    System.out.println(player.getPlayerName() + " selected the category: " + category);
                    playersInRound = this.getPlayersAsList();
                    deck.addToDiscardedPile(card);
                    card = null;
                    nextPlayerGoesFirstNextRound(player, playersInRound);
                    break;
                } else {
                    System.out.println(player.getPlayerName() + " Played the standard card " + cardToPlay.getTitle());
                    deck.addToDiscardedPile(card);
                    card = cardToPlay;
                }
                System.out.println(player.getPlayerName() + " card count: " + player.getCountOfCards() + "\n\n");

                System.out.println("\nPlayers left in round: " + playersInRound.size());
            }
        }
    }

    private void nextPlayerGoesFirstNextRound(Player player, ArrayList<Player> playersInRound) {
        int index = playersInRound.indexOf(player) + 1;
        index = index == playersInRound.size() ? 0 : index;
        playerGoesFirstNextRound(playersInRound.get(index), playersInRound);
    }

    private void playerGoesFirstNextRound(Player player, ArrayList<Player> playersInRound) {
        ArrayList<Player> tempPlayersInRoundList = new ArrayList<>();
        ArrayList<Player> temp2PlayersInRoundList = new ArrayList<>(playersInRound);

        for(Player p: temp2PlayersInRoundList){
            if(p != player){
                tempPlayersInRoundList.add(p);
                playersInRound.remove(p);
            }else{
                break;
            }
        }

        for(Player p: tempPlayersInRoundList){
            playersInRound.add(p);
        }
    }

    public Player getWinningPlayer(){
        for (Player player: players){
            if(player.getCountOfCards() == 1){
                System.out.println("\n\n" + player.getPlayerName() + "Won the whole game");
                return player;
            }
        }
        return null;
    }

    private ArrayList<Player> getPlayersAsList() {
        ArrayList<Player> playersInRound = new ArrayList<>();
        for (Player player : players) {
            playersInRound.add(player);
        }
        return playersInRound;
    }
}
