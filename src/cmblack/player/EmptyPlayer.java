package cmblack.player;

import cmblack.card.EmptyCard;
import cmblack.card.ICard;
import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.controller.IRoundActions;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class EmptyPlayer implements IPlayer {
    @Override
    public IPlayer addCard(ICard card) {
        return this;
    }

    @Override
    public IPlayer playCard(ICard cardToBeat, ICategory currentTrumpCategory, IRoundActions roundActions) {
        return this;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean equals(IPlayer player) {
        return this.getName().equals(player.getName());
    }

    @Override
    public ICategory chooseCategory(ICategory[] changeableCategories) {
        return chooseCategory();
    }

    @Override
    public ICategory chooseCategory() {
        return new EmptyCategory();
    }

    @Override
    public int getCountOfCards() {
        return 0;
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
