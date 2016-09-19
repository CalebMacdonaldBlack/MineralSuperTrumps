package cmblack.player.round;

import cmblack.card.ICard;
import cmblack.card.playcard.IPlayCard;
import cmblack.category.ICategory;
import cmblack.deck.IDeck;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRound {
    IPlayerGroup getPlayerGroup();
    ICard getCurrentCard();
    IDeck getDeck();
    ICategory getCurrentCategory();

    IRound setCurrentCard(ICard card);
    IRound setCurrentCategory(ICategory category);

    class FakeRound implements IRound {

        @Override
        public IPlayerGroup getPlayerGroup() {
            return new IPlayerGroup.FakePlayerGroup();
        }

        @Override
        public ICard getCurrentCard() {
            return new IPlayCard.FakeGoodPlayCard();
        }

        @Override
        public IDeck getDeck() {
            return new IDeck.FakeDeck();
        }

        @Override
        public ICategory getCurrentCategory() {
            return new ICategory.FakeCleavageCategory();
        }

        @Override
        public IRound setCurrentCard(ICard card) {
            return null;
        }

        @Override
        public IRound setCurrentCategory(ICategory category) {
            return null;
        }
    }
}
