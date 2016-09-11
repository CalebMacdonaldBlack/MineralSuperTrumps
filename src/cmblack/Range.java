package cmblack;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class Range implements IRange {

    private final double min, max;

    public Range(double min, double max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public double minValue() {
        return 0;
    }

    @Override
    public double maxValue() {
        return 0;
    }

    @Override
    public double percentageOfValueInRange(double value) {
        return 0;
    }
}
