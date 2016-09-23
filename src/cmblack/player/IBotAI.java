package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 23/9/16.
 */
public interface IBotAI {
    ICard findBestCard(IPlayer player, ICard currentCard, ICategory currentCategory);
    ICategory findBestCategory(IPlayer player, ICategory[] choices);

    class FakeBotAI implements IBotAI {

        @Override
        public ICard findBestCard(IPlayer player, ICard currentCard, ICategory currentCategory) {
            return new IPlayCard.FakeGoodPlayCard();
        }

        @Override
        public ICategory findBestCategory(IPlayer player,  ICategory[] choices) {
            return new ICategory.FakeCleavageCategory();
        }
    }
}
