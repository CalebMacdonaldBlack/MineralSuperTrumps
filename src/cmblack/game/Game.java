package cmblack.game;

import cmblack.deck.IDeck;
import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;
import cmblack.player.round.IRound;
import cmblack.player.round.IRoundResult;
import cmblack.player.round.Round;
import cmblack.player.round.RoundResult;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class Game implements IGame {

    private final IPlayer[] players;
    private final IDeck deck;

    public Game(IPlayer[] players, IDeck deck) {
        this.players = players;
        this.deck = deck;
    }

    @Override
    public void startGame() {
        System.out.println("\n\n============");
        System.out.println("Starting Game");
        System.out.println("============\n");
        distributeCards(players, deck);
        ArrayList<IPlayer> winners = new ArrayList<>();
        IPlayer currentPlayer = new EmptyPlayer();

        while(winners.size() < players.length - 1){
            IRoundResult roundResult = new Round(deck, players, currentPlayer).haveRound();
            addWinningPlayersToList(roundResult.playersWhoWon(), winners);
            currentPlayer = roundResult.roundWinningPlayer();
        }

        System.out.println("\n============");
        System.out.println("Done Game");
        System.out.println("============\n");
    }

    private void addWinningPlayersToList(IPlayer[] players, ArrayList<IPlayer> winners) {
        for(IPlayer player: players){
            winners.add(player);
        }
    }


    //TODO card distributer?
    private void distributeCards(IPlayer[] players, IDeck deck) {
        for(IPlayer player: players){
            for(int i=0; i<5;i++){
                player.giveCard(deck.takeCard());
            }
        }
    }
}
