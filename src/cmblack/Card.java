package cmblack;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public abstract class Card {
    private final String title, subTitle, imageFilename;

    public Card(String title, String subTitle, String imageFilename) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageFilename = imageFilename;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getImageFilename() {
        return imageFilename;
    }
}
