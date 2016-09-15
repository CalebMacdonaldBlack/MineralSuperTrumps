package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.Category;
import cmblack.category.ICategory;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IPlayer {
    IPlayer addCard(ICard card);
    ICard playCard(ICard cardToBeat, ICategory currentTrumpCategory);
    String getName();
    boolean equals(IPlayer player);

    ICategory chooseCategory();

    int getCountOfCards();

    void giveCard(ICard card);

    ArrayList<ICard> getCards();

    class FakePlayer implements IPlayer {

        private ArrayList<ICard> cards;

        @Override
        public IPlayer addCard(ICard card) {
            this.cards.add(card);
            return this;
        }

        @Override
        public ICard playCard(ICard cardToBeat, ICategory currentTrumpCategory) {
            return new ITrumpCard.FakeTrumpCard();
        }

        @Override
        public String getName() {
            return "Bot 1";
        }

        @Override
        public boolean equals(IPlayer player) {
            // TODO not very accurate
            return this.getName().equals(player.getName());
        }

        @Override
        public ICategory chooseCategory() {
            return new ICategory.FakeCleavageCategory();
        }

        @Override
        public int getCountOfCards() {
            return 1;
        }

        @Override
        public void giveCard(ICard card) {

        }

        @Override
        public ArrayList<ICard> getCards() {
            return new ArrayList<>();
        }
    }
}
