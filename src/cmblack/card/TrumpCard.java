package cmblack.card;

import cmblack.card.Card;
import cmblack.category.Category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class TrumpCard extends Card {
    private final Category[] categories;
    private final String subTitle;

    public TrumpCard(String title, String subTitle, String imageFilename, Category[] categories) {
        super(title, imageFilename);
        this.categories = categories;
        this.subTitle = subTitle;
    }

    public Category[] getCategories() {
        return categories;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
