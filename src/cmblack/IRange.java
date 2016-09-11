package cmblack;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IRange {
    double minValue();
    double maxValue();
    double percentageOfValueInRange(double value);

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
    }
}
