package App.Models.Card;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public enum EconomicValue {
    TRUMPCARD("trumpcard"),
    TRIVIAL("trivial"),
    LOW("low"),
    MODERATE("moderate"),
    HIGH("high"),
    VERY_HIGH("very high"),
    IM_RICH("I'm rich!");

    private final String text;

    EconomicValue(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
