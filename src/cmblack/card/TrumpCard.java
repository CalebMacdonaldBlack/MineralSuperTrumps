package cmblack.card;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class TrumpCard implements ITrumpCard {
    private final String[] categories;
    private final String subTitle;
    private final String title;
    private final String imageFileName;

    public TrumpCard(String title, String subTitle, String imageFilename, String[] categories) {
        this.categories = categories;
        this.subTitle = subTitle;
        this.title = title;
        this.imageFileName = imageFilename;
    }

    @Override
    public String[] getCategories() {
        return null;
    }

    @Override
    public String getSubTitle() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getImageFilename() {
        return null;
    }
}
