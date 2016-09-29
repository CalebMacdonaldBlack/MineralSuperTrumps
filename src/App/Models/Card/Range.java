package App.Models.Card;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Range {
    private final double lowValue, HighValue;

    public Range(double lowValue, double highValue) {
        this.lowValue = lowValue;
        HighValue = highValue;
    }

    public double getLowValue() {
        return lowValue;
    }

    public double getHighValue() {
        return HighValue;
    }
}
