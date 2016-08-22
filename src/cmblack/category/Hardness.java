package cmblack.category;

import cmblack.category.Category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class Hardness extends Category {
    private double rangeLow;
    private double rangeHigh;

    public Hardness(double rangeLow, double rangeHigh) {
        super("Hardness");
        this.rangeLow = rangeLow;
        this.rangeHigh = rangeHigh;
    }

    public double getRangeLow() {
        return rangeLow;
    }

    public double getRangeHigh() {
        return rangeHigh;
    }
}
