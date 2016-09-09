package cmblack.category.economicvalue;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public enum EconomicValueValue {
    TRIVIAL("trivial"),
    LOW("low"),
    MODERATE("moderate"),
    HIGH("high"),
    VERY_HIGH("very high"),
    IM_RICH("I'm rich!");

    private final String text;

    EconomicValueValue(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
