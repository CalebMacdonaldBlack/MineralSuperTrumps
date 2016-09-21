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
    void selectCategory(String categoryName);
    void selectCard(String cardName);

    class FakeRoundActions implements IRoundActions {

        @Override
        public void selectCategory(String categoryName) {

        }

        @Override
        public void selectCard(String cardName) {

        }
    }
}
