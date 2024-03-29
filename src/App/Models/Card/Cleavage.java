package App.Models.Card;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public enum Cleavage {
    TRUMPCARD("trumpcard"),
    NONE("none"),
    POOR_NONE("poor/none"),
    POOR1("1 poor"),
    POOR2("2 poor"),
    GOOD1("1 good"),
    GOOD1_POOR1("1 good, 1 poor"),
    GOOD2("2 good"),
    GOOD3("3 good"),
    PERFECT1("1 perfect"),
    PERFECT1_GOOD1("1 perfect, 1 good"),
    PERFECT1_GOOD2("1 perfect, 2 good"),
    PERFECT2_GOOD1("2 perfect, 1 good"),
    PERFECT3("3 perfect"),
    PERFECT4("4 perfect"),
    PERFECT6("6 perfect");

    private final String text;

    /**
     * Creates a new instance
     * @param text The text to return when displaying the value
     */
    Cleavage(String text) {
        this.text = text;
    }

    /**
     * The text on the card for the value
     *
     * @return The text on the card
     */
    public String getText(){
        return this.text;
    }
}
