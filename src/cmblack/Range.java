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
        return this.min;
    }

    @Override
    public double maxValue() {
        return this.max;
    }

    @Override
    public double percentageOfValueInRange(double value) {
        return ((value - min) * 100) / (max - min);
    }

    @Override
    public boolean equals(IRange range) {
        return min == range.minValue()
            && max == range.maxValue();
    }
}
