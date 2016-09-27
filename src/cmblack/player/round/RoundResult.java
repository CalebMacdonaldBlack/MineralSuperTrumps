package cmblack.player.round;

import cmblack.category.ICategory;
import cmblack.player.IPlayer;

import java.util.List;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResult implements IRoundResult {

    private final IPlayerGroup playerGroup;
    private final ICategory nextRoundCategory;
    private final List<IPlayer> playersToRemoveFromGame;

    public RoundResult(IPlayerGroup playerGroup, ICategory nextRoundCategory, List<IPlayer> playersToRemoveFromGame) {
        this.playerGroup = playerGroup;
        this.nextRoundCategory = nextRoundCategory;
        this.playersToRemoveFromGame = playersToRemoveFromGame;
    }


    @Override
    public IPlayerGroup getPlayerGroup() {
        return playerGroup;
    }

    @Override
    public ICategory getNextRoundCategory() {
        return nextRoundCategory;
    }

    @Override
    public List<IPlayer> getPlayersToRemoveFromGame() {
        return playersToRemoveFromGame;
    }
}
