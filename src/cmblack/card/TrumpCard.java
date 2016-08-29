package cmblack.card;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class TrumpCard extends Card {
    private final String[] categories;
    private final String subTitle;

    public TrumpCard(String title, String subTitle, String imageFilename, String[] categories) {
        super(title, imageFilename);
        this.categories = categories;
        this.subTitle = subTitle;
    }

    public String[] getCategories() {
        return categories;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
