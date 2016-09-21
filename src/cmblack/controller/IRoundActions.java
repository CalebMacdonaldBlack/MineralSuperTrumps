package cmblack.controller;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.player.IPlayer;
import cmblack.player.round.IRound;

/**
 * Created by calebmacdonaldblack on 16/09/2016.
 */
public interface IRoundActions {
    void selectedCategory(ICategory category);
    void selectedCard(ICard card);

    class FakeRoundActions implements IRoundActions {
        @Override
        public void selectedCategory(ICategory category) {

        }

        @Override
        public void selectedCard(ICard card) {

        }
    }
}
