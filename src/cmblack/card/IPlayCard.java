package cmblack.card;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IPlayCard extends ICard {
    ICardDescription getCardDescription();

    PlayCardStats getPlayCardStats();

    public class FakePlayCard implements IPlayCard {

        @Override
        public ICardDescription getCardDescription(){
            return null;
        }

        @Override
        public PlayCardStats getPlayCardStats() {
            return null;
        }

        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public String getImageFilename() {
            return null;
        }
    }
}
