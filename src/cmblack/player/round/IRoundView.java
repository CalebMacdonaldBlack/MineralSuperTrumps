package cmblack.player.round;

import cmblack.card.ICard;

/**
 * Created by calebmacdonaldblack on 19/09/2016.
 */
public interface IRoundView {
    void update(IRound round);

    ICard getCardSelection(ICard[] cards);

    class FakeRoundView implements IRoundView {

        @Override
        public void update(IRound round) {

        }

        @Override
        public ICard getCardSelection(ICard[] cards) {
            return null;
        }
    }
}
