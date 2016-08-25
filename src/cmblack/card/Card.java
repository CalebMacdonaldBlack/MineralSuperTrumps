package cmblack.card;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public abstract class Card {
    private final String title, imageFilename;

    public Card(String title, String imageFilename) {
        this.title = title;
        this.imageFilename = imageFilename;
    }

    public String getTitle() {
        return title;
    }

    public String getImageFilename() {
        return imageFilename;
    }
}
