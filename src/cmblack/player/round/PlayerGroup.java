package cmblack.player.round;

import cmblack.player.IPlayer;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 12/09/2016.
 */
public class PlayerGroup implements IPlayerGroup {

    private final ArrayList<IPlayer> remainingPlayers = new ArrayList<>();
    private final ArrayList<IPlayer> removedPlayers = new ArrayList<>();
    private final IPlayer[] players;

    public PlayerGroup(IPlayer[] players) {
        this.players = players;
    }


    @Override
    public IPlayer getNextPlayer(IPlayer player) {
        return null;
    }

    @Override
    public IPlayer removePlayer(IPlayer player) {
        return null;
    }

    @Override
    public ArrayList<IPlayer> getRemainingPlayers() {
        return null;
    }

    @Override
    public ArrayList<IPlayer> getRemovedPlayers() {
        return null;
    }
}
