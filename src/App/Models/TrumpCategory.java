package App.Models;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public enum TrumpCategory {
    ECONOMIC_VALUE("Economic value"),
    CRUSTAL_ABUNDANCE("Crustal abundance"),
    HARDNESS("Hardness"),
    CLEAVAGE("Cleavage"),
    SPECIFIC_GRAVITY("Specific gravity");

    private final String text;

    TrumpCategory(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
