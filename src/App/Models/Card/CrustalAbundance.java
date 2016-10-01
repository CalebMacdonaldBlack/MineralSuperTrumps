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

    CrustalAbundance(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
