package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class PlayerTurnResult implements IPlayerTurnResult {
    public PlayerTurnResult(IPlayCard.FakePlayCard fakePlayCard, IPlayer.FakePlayer fakePlayer, ICategory.FakeCleavageCategory fakeCleavageCategory) {

    }

    @Override
    public ICard getCurrentCard() {
        return null;
    }

    @Override
    public IPlayer getCurrentPlayer() {
        return null;
    }

    @Override
    public ICategory getCurrentCategory() {
        return null;
    }
}
