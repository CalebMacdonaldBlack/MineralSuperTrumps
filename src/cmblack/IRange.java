package cmblack;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRange {
    double minValue();
    double maxValue();
    double percentageOfValueInRange(double value);
    boolean equals(IRange range);

    class FakeRange implements IRange {

        @Override
        public double minValue() {
            return 6;
        }

        @Override
        public double maxValue() {
            return 10;
        }

        @Override
        public double percentageOfValueInRange(double value) {
            return ((value - minValue()) * 100) / (maxValue() - minValue());
        }

        @Override
        public boolean equals(IRange range) {
            return this.minValue() == range.minValue()
                && this.maxValue() == range.maxValue();
        }
    }
}
