package cmblack.card.stats;

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
        return null;
    }
}
