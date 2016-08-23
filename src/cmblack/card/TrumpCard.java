package cmblack.card;

import cmblack.card.Card;
import cmblack.category.Category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class TrumpCard extends Card {
    private final Category[] categories;

    public TrumpCard(String title, String subTitle, String imageFilename, Category[] categories) {
        super(title, subTitle, imageFilename);
        this.categories = categories;
    }

    public Category[] getCategories() {
        return categories;
    }
}
