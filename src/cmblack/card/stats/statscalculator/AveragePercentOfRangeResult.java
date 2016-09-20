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
    public ICategory getCategoryOfHighestPercentage(ICategory[] categories) {

        double[] myArray = new double[]{
                this.hardnessAveragePercentOfRange,
                this.cleavageAveragePercentOfRange,
                this.crustalAbundanceAveragePercentOfRange,
                this.economicValueAveragePercentOfRange,
                this.specificGravityAveragePercentOfRange
        };
        Arrays.sort(myArray);

        for(int count=1;count<myArray.length;count++){
            if(this.hardnessAveragePercentOfRange == myArray[myArray.length - count] && categoriesContains(new HardnessCategory(), categories)){
                return new HardnessCategory();
            }else if(this.cleavageAveragePercentOfRange == myArray[myArray.length - count] && categoriesContains(new CleavageCategory(), categories)){
                return new CleavageCategory();
            }else if(this.crustalAbundanceAveragePercentOfRange == myArray[myArray.length - count] && categoriesContains(new CrustalAbundanceCategory(), categories)){
                return new CrustalAbundanceCategory();
            }else if(this.economicValueAveragePercentOfRange == myArray[myArray.length - count] && categoriesContains(new EconomicValueCategory(), categories)){
                return new EconomicValueCategory();
            }else if(this.specificGravityAveragePercentOfRange == myArray[myArray.length - count] && categoriesContains(new SpecificGravityCategory(), categories)){
                return new SpecificGravityCategory();
            }
        }

        System.out.println(myArray[0] +" "+ myArray[1] +" "+ myArray[2] +" "+ myArray[3] +" "+ myArray[4]);
        System.out.println(categories[0].getCategoryName());
        System.out.println(cleavageAveragePercentOfRange);
        throw new NullPointerException("Cannot find a valid category in categories variable with length of " + categories.length + ". It could be possible that the player has no playcards and can't make a valid comparison");
    }

    private boolean categoriesContains(ICategory category, ICategory[] categories){
        for(ICategory c: categories){
            System.out.println(c.getCategoryName() + " - " + category.getCategoryName());
            if(c.equals(category)){
                System.out.println("true");
                return true;
            }
        }
        return false;
    }
}
