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

    /**
     * Creates a new instance of trump category
     *
     * @param text Trump category display text
     */
    TrumpCategory(String text) {
        this.text = text;
    }

    /**
     * Display text for category
     *
     * @return Display text
     */
    public String getText() {
        return text;
    }
}
