package App.Models.Card;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public enum CrustalAbundance {
    TRUMPCARD("trumpcard"),
    ULTRATRACE("ultratrace"),
    TRACE("trace"),
    LOW("low"),
    MODERATE("moderate"),
    HIGH("high"),
    VERY_HIGH("very high");

    private final String text;

    /**
     * Creates a new instance
     *
     * @param text The text to return when displaying the value
     */
    CrustalAbundance(String text) {
        this.text = text;
    }

    /**
     * The text on the card for the value
     *
     * @return The text on the card
     */
    public String getText() {
        return this.text;
    }
}
