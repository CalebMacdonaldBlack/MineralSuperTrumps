package cmblack.card.trumpcard;

import cmblack.card.ICard;
import cmblack.card.CardType;
import cmblack.card.stats.IStats;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ITrumpCard extends ICard {
    ICategory[] getCategories();
    String getSubTitle();

    class FakeTrumpCard implements ITrumpCard {

        @Override
        public ICategory[] getCategories() {
            return new ICategory[]{new ICategory.FakeCleavageCategory()};
        }

        @Override
        public String getSubTitle() {
            return "Changes the trump category to Cleavage";
        }

        @Override
        public String getTitle() {
            return "The Mineralogist";
        }

        @Override
        public String getImageFilename() {
            return "slide58.jpg";
        }

        @Override
        public CardType getType() {
            return null;
        }

        @Override
        public IStats getStats() {
            return null;
        }

        @Override
        public boolean equals(ICard card) {
            return false;
        }
    }
}
