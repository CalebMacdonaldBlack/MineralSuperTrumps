package cmblack.player.round;

import cmblack.player.IPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroup implements IPlayerGroup {

    private final IPlayer[] playersStillInGame;
    private final IPlayer[] playersStillInRound;
    private final IPlayer currentPlayer;


    public PlayerGroup(IPlayer[] allPlayers, IPlayer[] playersStillIn, IPlayer player) {
        this.playersStillInGame = allPlayers;
        this.playersStillInRound = playersStillIn;
        currentPlayer = player;
    }

    public PlayerGroup(IPlayer[] players, IPlayer player){
        this(players, players, player);
    }

    public PlayerGroup(IPlayer[] players){
        this(players, players[0]);
    }

    public IPlayer[] getPlayersStillInGame() {
        return playersStillInGame;
    }

    public IPlayer[] getPlayersStillInRound() {
        return playersStillInRound;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public IPlayerGroup nextPlayerTurn() {
        if(getPlayersStillInRound().length < 2){
            throw new NullPointerException("You need at least 2 players to find the next player");
        }

        return new PlayerGroup(playersStillInGame, getPlayersStillInRound(), findNextPlayerAfter(currentPlayer));
    }

    private IPlayer findNextPlayerAfter(IPlayer player) {
        IPlayer nextPlayerInArray = null;
        for(int i = 0; i< playersStillInGame.length; i++){
            if(player.equals(playersStillInGame[i])){
                if(i == playersStillInGame.length - 1){
                    nextPlayerInArray = playersStillInGame[0];
                } else {
                    nextPlayerInArray = playersStillInGame[i + 1];
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
        for(IPlayer p: playersStillInRound){
            if(p.equals(player)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(IPlayerGroup playerGroup) {
        // TODO: 19/09/2016 Not accurate fix it
        return playerGroup.getPlayersStillInGame().length == playersStillInGame.length
            && playerGroup.getPlayersStillInRound().length == playersStillInRound.length;
    }

    @Override
    public IPlayerGroup removePlayerFromRound(IPlayer player) {
        List<IPlayer> playersStillIn = new ArrayList<>();
        for(IPlayer p: this.playersStillInRound){
            if(!player.equals(p)){
                playersStillIn.add(p);
            }
        }
        return new PlayerGroup(playersStillInGame, playersStillIn.toArray(new IPlayer[playersStillIn.size()]), currentPlayer);
    }

    @Override
    public IPlayerGroup removePlayerFromGame(IPlayer player) {
        List<IPlayer> playersStillIn = new ArrayList<>();
        for(IPlayer p: this.playersStillInGame){
            if(!player.equals(p)){
                playersStillIn.add(p);
            }
        }
        IPlayerGroup playerGroup = this.removePlayerFromRound(player);
        return new PlayerGroup(playersStillIn.toArray(new IPlayer[playersStillIn.size()]),playerGroup.getPlayersStillInRound(), currentPlayer);
    }
}
