package cmblack.card.trumpcard;

import cmblack.card.ICard;
import cmblack.card.CardType;
import cmblack.card.stats.IStats;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ITrumpCard extends ICard {
    String getSubTitle();

    class FakeTrumpCard implements ITrumpCard {

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
            return CardType.TRUMP_CARD;
        }

        @Override
        public IStats getStats() {
            return new TrumpCardStats();
        }

        @Override
        public boolean equals(ICard card) {
            return card.getImageFilename().equals(this.getImageFilename())
                    && card.getTitle().equals(this.getTitle())
                    && card.getType().equals(CardType.TRUMP_CARD)
                    && card.getStats().equals(this.getStats());
        }

        @Override
        public ICategory[] changeableTrumpCategories() {
            return new ICategory[]{new ICategory.FakeCleavageCategory()};
        }
    }

    class FakeTrumpCard2 implements ITrumpCard {

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
            return CardType.TRUMP_CARD;
        }

        @Override
        public IStats getStats() {
            return new TrumpCardStats();
        }

        @Override
        public boolean equals(ICard card) {
            return card.getImageFilename().equals(this.getImageFilename())
                    && card.getTitle().equals(this.getTitle())
                    && card.getType().equals(CardType.TRUMP_CARD)
                    && card.getStats().equals(this.getStats());
        }

        @Override
        public ICategory[] changeableTrumpCategories() {
            return new ICategory[]{new ICategory.FakeHardnessCategory()};
        }
    }
}
