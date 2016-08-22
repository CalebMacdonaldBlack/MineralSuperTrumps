package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class SpecificGravity extends Category {
    private final double rangeLow, rangeHigh;

    public SpecificGravity(double rangeLow, double rangeHigh) {
        super("");
        this.rangeLow = 0;
        this.rangeHigh = 0;
    }

    public double getRangeLow() {
        return rangeLow;
    }

    public double getRangeHigh() {
        return rangeHigh;
    }
}
