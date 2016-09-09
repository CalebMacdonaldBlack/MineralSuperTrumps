package cmblack.card;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IPlayCard extends ICard {
    ICardDescription getCardDescription();

    PlayCardStats getPlayCardStats();

    class FakePlayCard implements IPlayCard {

        @Override
        public ICardDescription getCardDescription(){
            return new ICardDescription.FakeCardDescription();
        }

        @Override
        public PlayCardStats getPlayCardStats() {
            return null;
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
