package cmblack.card.stats;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class AveragePercentOfRangeResult implements IAveragePercentOfRangeResult {

    private final double hardnessAveragePercentOfRange;
    private final double cleavageAveragePercentOfRange;
    private final double crustalAbundanceAveragePercentOfRange;
    private final double economicValueAveragePercentOfRange;
    private final double specificGravityAveragePercentOfRange;

    public AveragePercentOfRangeResult(double hardnessAveragePercentOfRange, double cleavageAveragePercentOfRange, double crustalAbundanceAveragePercentOfRange, double economicValueAveragePercentOfRange, double specificGravityAveragePercentOfRange) {
        this.hardnessAveragePercentOfRange = hardnessAveragePercentOfRange;
        this.cleavageAveragePercentOfRange = cleavageAveragePercentOfRange;
        this.crustalAbundanceAveragePercentOfRange = crustalAbundanceAveragePercentOfRange;
        this.economicValueAveragePercentOfRange = economicValueAveragePercentOfRange;
        this.specificGravityAveragePercentOfRange = specificGravityAveragePercentOfRange;
    }


    @Override
    public double hardnessAveragePercentOfRange() {
        return 0;
    }

    @Override
    public double cleavageAveragePercentOfRange() {
        return 0;
    }

    @Override
    public double crustalAbundanceAveragePercentOfRange() {
        return 0;
    }

    @Override
    public double economicValueAveragePercentOfRange() {
        return 0;
    }

    @Override
    public double specificGravityAveragePercentOfRange() {
        return 0;
    }
}
