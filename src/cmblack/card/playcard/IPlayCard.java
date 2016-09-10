package cmblack.card.playcard;

import cmblack.card.CardType;
import cmblack.card.ICard;
import cmblack.card.playcard.carddescription.ICardDescription;
import cmblack.card.stats.IStats;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IPlayCard extends ICard {
    ICardDescription getCardDescription();

    class FakePlayCard implements IPlayCard {

        @Override
        public ICardDescription getCardDescription(){
            return new ICardDescription.FakeCardDescription();
        }

        @Override
        public IStats getStats() {
            return new IStats.FakePlayCardStats();
        }

        @Override
        public boolean equals(ICard playCard) {
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
        public CardType getType() {
            return CardType.PLAY_CARD;
        }
    }
    class FakePlayCard1 implements IPlayCard {

        @Override
        public ICardDescription getCardDescription(){
            return new ICardDescription.FakeCardDescription();
        }

        @Override
        public IStats getStats() {
            return new IStats.FakePlayCardStats2();
        }

        @Override
        public boolean equals(ICard playCard) {
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
        public CardType getType() {
            return CardType.PLAY_CARD;
        }
    }
}
