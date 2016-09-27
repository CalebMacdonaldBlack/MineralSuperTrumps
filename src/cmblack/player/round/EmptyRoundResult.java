package cmblack.player.round;

import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;

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
}
