package cmblack.player.round;

import cmblack.player.EmptyPlayer;
import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroup implements IPlayerGroup {

    private final ArrayList<IPlayer> remainingPlayers;
    private final ArrayList<IPlayer> removedPlayers = new ArrayList<>();
    private final IPlayer[] players;

    public PlayerGroup(IPlayer[] players) {
        this.players = players;
        this.remainingPlayers = playersAsArrayList(players);
    }

    private ArrayList<IPlayer>  playersAsArrayList(IPlayer[] players) {
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
}
