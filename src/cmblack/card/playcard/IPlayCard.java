package cmblack.card.playcard;

import cmblack.card.CategoryComparisonResult;
import cmblack.card.ICard;
import cmblack.card.ICardDescription;
import cmblack.card.playcard.playcardstats.IPlayCardStats;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IPlayCard extends ICard {
    ICardDescription getCardDescription();

    IPlayCardStats getPlayCardStats();

    boolean equals(IPlayCard playCard);

    class FakePlayCard implements IPlayCard {

        @Override
        public ICardDescription getCardDescription(){
            return new ICardDescription.FakeCardDescription();
        }

        @Override
        public IPlayCardStats getPlayCardStats() {
            return new IPlayCardStats.FakePlayCardStats();
        }

        @Override
        public boolean equals(IPlayCard playCard) {
            return false;
        }

        @Override
        public String getTitle() {
            return "Gold";
        }

        @Override
        public String getImageFilename() {
            return "Slide33.jpg";
        }

        @Override
        public CardType type() {
            return CardType.PLAY_CARD;
        }

        @Override
        public CategoryComparisonResult compareWith(ICard card) {
            return null;
        }
    }
    class FakePlayCard1 implements IPlayCard {

        @Override
        public ICardDescription getCardDescription(){
            return new ICardDescription.FakeCardDescription();
        }

        @Override
        public IPlayCardStats getPlayCardStats() {
            return new IPlayCardStats.FakePlayCardStats();
        }

        @Override
        public boolean equals(IPlayCard playCard) {
            return false;
        }

        @Override
        public String getTitle() {
            return "Gold";
        }

        @Override
        public String getImageFilename() {
            return "Slide33.jpg";
        }

        @Override
        public CardType type() {
            return CardType.PLAY_CARD;
        }

        @Override
        public CategoryComparisonResult compareWith(ICard card) {
            return null;
        }
    }
}
