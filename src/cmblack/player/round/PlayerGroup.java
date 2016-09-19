package cmblack.player.round;

import cmblack.player.IPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroup implements IPlayerGroup {

    private final IPlayer[] allPlayers;
    private final IPlayer[] playersStillIn;
    private final IPlayer currentPlayer;


    public PlayerGroup(IPlayer[] allPlayers, IPlayer[] playersStillIn, IPlayer player) {
        this.allPlayers = allPlayers;
        this.playersStillIn = playersStillIn;
        currentPlayer = player;
    }

    public PlayerGroup(IPlayer[] players, IPlayer player){
        this(players, players, player);
    }

    public PlayerGroup(IPlayer[] players){
        this(players, players[0]);
    }

    @Override
    public IPlayer[] getAllPlayers() {
        return allPlayers;
    }

    @Override
    public IPlayer[] getPlayersStillIn() {
        return playersStillIn;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public IPlayerGroup nextPlayerTurn() {
        if(getPlayersStillIn().length < 2){
            throw new NullPointerException("You need at least 2 players to find the next player");
        }

        return new PlayerGroup(allPlayers, getPlayersStillIn(), findNextPlayerAfter(currentPlayer));
    }

    private IPlayer findNextPlayerAfter(IPlayer player) {
        IPlayer nextPlayerInArray = null;
        for(int i=0;i<allPlayers.length;i++){
            if(player.equals(allPlayers[i])){
                if(i == allPlayers.length - 1){
                    nextPlayerInArray = allPlayers[0];
                } else {
                    nextPlayerInArray = allPlayers[i + 1];
                }
                break;
            }
        }

        if(nextPlayerInArray == null){
            throw new NullPointerException("cannot find player: " + player.getName() + " in the list of players");
        } else if(!playerIsStillIn(nextPlayerInArray)){
            return findNextPlayerAfter(nextPlayerInArray);
        } else {
            return nextPlayerInArray;
        }
    }

    private boolean playerIsStillIn(IPlayer player) {
        for(IPlayer p: playersStillIn){
            if(p.equals(player)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(IPlayerGroup playerGroup) {
        // TODO: 19/09/2016 Not accurate fix it
        return playerGroup.getAllPlayers().length == allPlayers.length
            && playerGroup.getPlayersStillIn().length == playersStillIn.length;
    }

    @Override
    public IPlayerGroup removePlayerFromRound(IPlayer player) {
        List<IPlayer> playersStillIn = new ArrayList<>();
        for(IPlayer p: this.playersStillIn){
            if(!player.equals(p)){
                playersStillIn.add(p);
            }
        }
        return new PlayerGroup(allPlayers, playersStillIn.toArray(new IPlayer[playersStillIn.size()]), currentPlayer);
    }

    @Override
    public IPlayerGroup removePlayerFromGame(IPlayer player) {
        List<IPlayer> allPlayers = new ArrayList<>();
        for(IPlayer p: this.allPlayers){
            if(!player.equals(p)){
                allPlayers.add(p);
            }
        }
        IPlayerGroup playerGroup = this.removePlayerFromRound(player);
        return new PlayerGroup(allPlayers.toArray(new IPlayer[allPlayers.size()]), playerGroup.getPlayersStillIn(), playerGroup.getCurrentPlayer());
    }
}
