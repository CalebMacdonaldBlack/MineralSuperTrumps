package cmblack.game;

import cmblack.player.Player;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 5/09/2016.
 */
public class PlayerCircle{
    private ArrayList<Player> players = new ArrayList<>();
    private final Player[] allPlayers;
    private Player currentPlayer;

    public PlayerCircle(Player[] players){
        for(Player player: players){
            this.players.add(player);
        }
        this.allPlayers = players;
        this.currentPlayer = players[players.length - 1];
    }

    public Player nextPlayer(){
        int nextPlayerIndex;
        if(players.indexOf(currentPlayer) + 1 == players.size()){
            nextPlayerIndex = 0;
        } else {
            nextPlayerIndex = players.indexOf(currentPlayer) + 1;
        }
        currentPlayer = players.get(nextPlayerIndex);
        return players.get(nextPlayerIndex);
    }

    public Player currentPlayer() {
        return this.currentPlayer;
    }

    public void remove(Player player2) {
        this.players.remove(player2);
    }

    public boolean hasNext() {
        return this.players.size() > 1;
    }

    public Player getRoundWinningPlayer() {
        if(this.hasNext()){
            return null;
        }
        return this.players.get(0);
    }

    public void resetRoundUsingWinningPlayer() {
        Player winningPlayer = getRoundWinningPlayer();
        this.players = new ArrayList<>();
        for(Player player: allPlayers){
            this.players.add(player);
        }
        if(players.indexOf(winningPlayer) == 0){
            currentPlayer = players.get(players.size() - 1);
        }else{
            currentPlayer = players.get(players.indexOf(winningPlayer) - 1);
        }

    }
}
