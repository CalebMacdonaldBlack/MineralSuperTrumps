package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class SpecificGravity extends Category {
    private final double rangeLow, rangeHigh;

    public SpecificGravity(double rangeLow, double rangeHigh) {
        super("Specific gravity");
        this.rangeLow = rangeLow;
        this.rangeHigh = rangeHigh;
    }

    public SpecificGravity(String name, double rangeLow, double rangeHigh){
        super("");
    }

    public double getRangeLow() {
        return rangeLow;
    }

    public double getRangeHigh() {
        return rangeHigh;
    }
}
