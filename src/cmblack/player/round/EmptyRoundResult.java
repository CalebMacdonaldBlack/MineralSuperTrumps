package cmblack.player.round;

import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by calebmacdonaldblack on 26/9/16.
 */
public class EmptyRoundResult implements IRoundResult {
    @Override
    public IPlayerGroup getPlayerGroup() {
        return new EmptyPlayerGroup();
    }

    @Override
    public ICategory getNextRoundCategory() {
        return new EmptyCategory();
    }

    @Override
    public List<IPlayer> getPlayersToRemoveFromGame() {
        return new ArrayList<>();
    }
}
