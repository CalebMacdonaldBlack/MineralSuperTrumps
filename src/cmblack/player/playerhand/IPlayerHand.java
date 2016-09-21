package cmblack.player.playerhand;

import cmblack.card.ICard;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 21/9/16.
 */
public interface IPlayerHand {
    IPlayerHand giveCard(ICard card);
    IPlayerHand removeCard(ICard card);
    ArrayList<ICard> getCards();
    int getCountOfCards();

    class FakePlayerHand implements IPlayerHand{

        @Override
        public IPlayerHand giveCard(ICard card) {
            return null;
        }

        @Override
        public IPlayerHand removeCard(ICard card) {
            return null;
        }

        @Override
        public ArrayList<ICard> getCards() {
            return null;
        }

        @Override
        public int getCountOfCards() {
            return 0;
        }
    }
}
