package cmblack.player.turn;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IPlayerTurnResult {
    ICard getCurrentCard();
    IPlayer getCurrentPlayer();
    ICategory getCurrentCategory();

    class FakePlayerTurnResult implements IPlayerTurnResult {

        @Override
        public ICard getCurrentCard() {
            return new IPlayCard.FakeBadPlayCard();
        }

        @Override
        public IPlayer getCurrentPlayer() {
            return new IPlayer.FakePlayer();
        }

        @Override
        public ICategory getCurrentCategory() {
            return new ICategory.FakeCleavageCategory();
        }
    }
}
