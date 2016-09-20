package cmblack.player;

import cmblack.card.ICard;
import cmblack.card.trumpcard.ITrumpCard;
import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.controller.IRoundActions;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IPlayer {
    IPlayer addCard(ICard card);
    IPlayer playCard(ICard cardToBeat, ICategory currentTrumpCategory, IRoundActions roundActions);
    String getName();
    boolean equals(IPlayer player);

    ICategory chooseCategory(ICategory[] changeableCategories);
    ICategory chooseCategory();

    int getCountOfCards();

    IPlayer giveCard(ICard card);

    ArrayList<ICard> getCards();

    class FakePlayer implements IPlayer {

        private ArrayList<ICard> cards;

        @Override
        public IPlayer addCard(ICard card) {
            this.cards.add(card);
            return this;
        }

        @Override
        public IPlayer playCard(ICard cardToBeat, ICategory currentTrumpCategory, IRoundActions roundActions) {
            return this;
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
        public ICategory chooseCategory(ICategory[] changeableCategories) {
            return chooseCategory();
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
        public IPlayer giveCard(ICard card) {
            return this;
        }

        @Override
        public ArrayList<ICard> getCards() {
            return new ArrayList<>();
        }
    }
}
