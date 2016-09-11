package cmblack.card.stats.statscalculator;

import cmblack.category.ICategory;
import cmblack.category.cleavage.CleavageCategory;
import cmblack.category.crustalabundance.CrustalAbundanceCategory;
import cmblack.category.economicvalue.EconomicValueCategory;
import cmblack.category.hardness.HardnessCategory;
import cmblack.category.specificgravity.SpecificGravityCategory;

import java.util.Arrays;

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
        return this.hardnessAveragePercentOfRange;
    }

    @Override
    public double cleavageAveragePercentOfRange() {
        return this.cleavageAveragePercentOfRange;
    }

    @Override
    public double crustalAbundanceAveragePercentOfRange() {
        return this.crustalAbundanceAveragePercentOfRange;
    }

    @Override
    public double economicValueAveragePercentOfRange() {
        return this.economicValueAveragePercentOfRange;
    }

    @Override
    public double specificGravityAveragePercentOfRange() {
        return this.specificGravityAveragePercentOfRange;
    }

    @Override
    public ICategory getCategoryOfHighestPercentage() {

        double[] myArray = new double[]{
                this.hardnessAveragePercentOfRange,
                this.cleavageAveragePercentOfRange,
                this.crustalAbundanceAveragePercentOfRange,
                this.economicValueAveragePercentOfRange,
                this.specificGravityAveragePercentOfRange
        };
        Arrays.sort(myArray);
        double max = myArray[myArray.length - 1];

        if(this.hardnessAveragePercentOfRange == max){
            return new HardnessCategory();
        }else if(this.cleavageAveragePercentOfRange == max){
            return new CleavageCategory();
        }else if(this.crustalAbundanceAveragePercentOfRange == max){
            return new CrustalAbundanceCategory();
        }else if(this.economicValueAveragePercentOfRange == max){
            return new EconomicValueCategory();
        }else {
            return new SpecificGravityCategory();
        }
    }
}
