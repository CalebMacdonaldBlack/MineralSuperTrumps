package cmblack.card.stats;

import cmblack.IRange;
import cmblack.category.IStat;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class AveragePercentOfRangeCalculator implements IAveragePercentOfRangeCalculator {

    private final ArrayList<IStats> listOfStats = new ArrayList<>();

    @Override
    public void addStats(IStats stats) {
        listOfStats.add(stats);
    }

    @Override
    public IAveragePercentOfRangeResult calculateAverage() {
        double hardness = 0, specificGravity = 0, cleavage = 0, crustalAbundance = 0, economicValue = 0;

        for(IStats stats: listOfStats){
            hardness += findPercentageInRange(stats.getHardness().getCategory().getValueRange(), stats.getHardness().getMaximumValue());
            specificGravity += findPercentageInRange(stats.getSpecificGravity().getCategory().getValueRange(), stats.getSpecificGravity().getMaximumValue());
            cleavage += findPercentageInRange(stats.getCleavage().getCategory().getValueRange(), stats.getCleavage().getValue().ordinal());
            crustalAbundance += findPercentageInRange(stats.getCrustalAbundance().getCategory().getValueRange(), stats.getCrustalAbundance().getValue().ordinal());
            economicValue += findPercentageInRange(stats.getEconomicValue().getCategory().getValueRange(), stats.getEconomicValue().getValue().ordinal());
        }

        return new AveragePercentOfRangeResult(hardness / listOfStats.size(), cleavage / listOfStats.size(), crustalAbundance / listOfStats.size(), economicValue / listOfStats.size(), specificGravity / listOfStats.size());
    }

    private double findPercentageInRange(IRange range, double value){
        return ((value - range.minValue()) * 100) / (range.maxValue() - range.minValue());
    }
}
