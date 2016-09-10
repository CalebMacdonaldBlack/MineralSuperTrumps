package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.Category;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IPlayer {
    IPlayer addCard(ICard card);
    ICard playCard(ICard cardToBeat, Category currentTrumpCategory);
    String getName();

    class FakePlayer implements IPlayer {

        private ArrayList<ICard> cards;

        @Override
        public IPlayer addCard(ICard card) {
            this.cards.add(card);
            return this;
        }

        @Override
        public ICard playCard(ICard cardToBeat, Category currentTrumpCategory) {
            return new ITrumpCard.FakeTrumpCard();
        }

        @Override
        public String getName() {
            return "Bot 1";
        }
    }
}
