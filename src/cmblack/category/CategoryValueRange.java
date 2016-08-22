package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class CategoryValueRange {
    private double low;
    private double high;

    public CategoryValueRange(double low, double high) {
        this.low = low;
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }
}
