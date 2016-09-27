package cmblack.player.round;

import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RoundResult implements IRoundResult {

    private final IPlayerGroup playerGroup;
    private final ICategory nextRoundCategory;

    public RoundResult(IPlayerGroup playerGroup, ICategory nextRoundCategory) {
        this.playerGroup = playerGroup;
        this.nextRoundCategory = nextRoundCategory;
    }


    @Override
    public IPlayerGroup getPlayerGroup() {
        return playerGroup;
    }

    @Override
    public ICategory getNextRoundCategory() {
        return nextRoundCategory;
    }
}
