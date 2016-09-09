package cmblack.card.playcard;

import cmblack.card.ICard;
import cmblack.card.ICardDescription;
import cmblack.card.playcard.playcardstats.IPlayCardStats;
import cmblack.card.playcard.playcardstats.PlayCardStats;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IPlayCard extends ICard {
    ICardDescription getCardDescription();

    IPlayCardStats getPlayCardStats();

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
        public String getTitle() {
            return "Gold";
        }

        @Override
        public String getImageFilename() {
            return "Slide33.jpg";
        }
    }
}
