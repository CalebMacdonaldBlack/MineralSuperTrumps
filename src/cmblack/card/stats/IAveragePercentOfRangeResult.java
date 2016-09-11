package cmblack.card.stats;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IAveragePercentOfRangeResult {
    double hardnessAveragePercentOfRange();
    double cleavageAveragePercentOfRange();
    double crustalAbundanceAveragePercentOfRange();
    double economicValueAveragePercentOfRange();
    double specificGravityAveragePercentOfRange();

    class FakeAveragePercentOfRangeResult implements IAveragePercentOfRangeResult {

        @Override
        public double hardnessAveragePercentOfRange() {
            return 55;
        }

        @Override
        public double cleavageAveragePercentOfRange() {
            return 40;
        }

        @Override
        public double crustalAbundanceAveragePercentOfRange() {
            return 63;
        }

        @Override
        public double economicValueAveragePercentOfRange() {
            return 70;
        }

        @Override
        public double specificGravityAveragePercentOfRange() {
            return 40;
        }
    }
}
