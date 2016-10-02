package App.Models.Card;

/**
 * Created by calebmacdonaldblack on 29/09/2016.
 */
public class Range {
    private final double lowValue, HighValue;

    /**
     * Creates a new instance
     * @param lowValue The low value in the range
     * @param highValue The high value in the range
     */
    public Range(double lowValue, double highValue) {
        this.lowValue = lowValue;
        HighValue = highValue;
    }

    /**
     * Low value
     * @return Low Value
     */
    public double getLowValue() {
        return lowValue;
    }

    /**
     * Low value
     * @return Low value
     */
    public double getHighValue() {
        return HighValue;
    }
}
