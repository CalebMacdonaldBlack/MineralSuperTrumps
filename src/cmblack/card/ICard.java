package cmblack.card;

import cmblack.card.stats.IStats;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public interface ICard {

    String getTitle();

    String getImageFilename();

    CardType getType();

    IStats getStats();

    boolean equals(ICard card);

    ICategory[] changeableTrumpCategories();
}
