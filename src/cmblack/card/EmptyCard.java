package cmblack.card;

import cmblack.card.stats.EmptyStats;
import cmblack.card.stats.IStats;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyCard implements ICard {
    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getImageFilename() {
        return "";
    }

    @Override
    public CardType getType() {
        return CardType.EMPTY_CARD;
    }

    @Override
    public IStats getStats() {
        return new EmptyStats();
    }

    @Override
    public boolean equals(ICard card) {
        return card.getTitle().equals("")
            && card.getType().equals(CardType.EMPTY_CARD)
            && card.getImageFilename().equals("")
            && card.getStats().equals(new EmptyStats());
    }

    @Override
    public ICategory[] changeableTrumpCategories() {
        return new ICategory[0];
    }
}
