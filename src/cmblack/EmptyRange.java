package cmblack;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class EmptyRange implements IRange {
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

    @Override
    public boolean equals(IRange range) {
        return range.minValue() == minValue()
            && range.maxValue() == maxValue();
    }
}
