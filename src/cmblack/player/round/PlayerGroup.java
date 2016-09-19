package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroup implements IPlayerGroup {

    private final ArrayList<IPlayer> remainingPlayers;
    private final ArrayList<IPlayer> removedPlayers;
    private final IPlayer[] players;
    private final IPlayer currentPlayer;

    public PlayerGroup(IPlayer[] players, IPlayer currentPlayer, ArrayList<IPlayer> remainingPlayers, ArrayList<IPlayer> removedPlayers) {
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.remainingPlayers = remainingPlayers;
        this.removedPlayers = removedPlayers;

    }

    public PlayerGroup(IPlayer[] players) {
        this(players, players[0], playersAsArrayList(players), new ArrayList<IPlayer>());
    }

    private static ArrayList<IPlayer>  playersAsArrayList(IPlayer[] players) {
        ArrayList<IPlayer> playersArrayList = new ArrayList<>();

        for(IPlayer player: players){
            playersArrayList.add(player);
        }
        return playersArrayList;
    }


    @Override
    public IPlayer getNextPlayer(IPlayer currentPlayer) {
        if(currentPlayer.equals(new EmptyPlayer())){
            return remainingPlayers.get(0);
        }

        for(int i=0;i<remainingPlayers.size();i++){
            if(remainingPlayers.get(i).equals(currentPlayer)){
                if(i == remainingPlayers.size() -1){
                    return remainingPlayers.get(0);
                }else{
                    return remainingPlayers.get(i + 1);
                }
            }
        }
        throw new NullPointerException(currentPlayer.getName() + " cound not be found in the players in round");
    }

    @Override
    public IPlayerGroup removePlayer(IPlayer player) {
        this.remainingPlayers.remove(player);
        this.removedPlayers.add(player);
        return this;
    }

    @Override
    public ArrayList<IPlayer> getRemainingPlayers() {
        return this.remainingPlayers;
    }

    @Override
    public ArrayList<IPlayer> getRemovedPlayers() {
        return this.removedPlayers;
    }

    @Override
    public IPlayer getRoundWinningPlayer() {
        return remainingPlayers.size() > 1 ? new EmptyPlayer() : remainingPlayers.get(0);
    }

    @Override
    public IPlayer getPlayerAt(int index) {
        return players[index];
    }

    @Override
    public boolean equals(IPlayerGroup playerGroup) {
        if(!playerGroup.getCurrentPlayer().equals(currentPlayer)){
            return false;
        }

        try {
            for (int i = remainingPlayers.size(); i > 0; i--) {
                if (!remainingPlayers.get(i - 1).equals(playerGroup.getRemainingPlayers().get(i - 1))) {
                    return false;
                }
            }
            for (int i = removedPlayers.size(); i > 0; i--) {
                if (!removedPlayers.get(i - 1).equals(playerGroup.getRemovedPlayers().get(i - 1))) {
                    return false;
                }
            }
            return true;
        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public IPlayerGroup setCurrentPlayer(IPlayer player) {
        if(!remainingPlayers.contains(player)){
            throw new NullPointerException(player.getName() + " is not in remaining players and cannot be set as the current player!");
        }
        return new PlayerGroup(players, player, remainingPlayers, removedPlayers);
    }
}
