package cmblack.card.stats;

import cmblack.category.IStat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IAveragePercentOfRangeCalculator {
    void addStats(IStats stat);
    IAveragePercentOfRangeResult calculateAverage(IStat stat);

    class FakeAveragePercentOfRangeCalculator implements IAveragePercentOfRangeCalculator {

        ArrayList<IStats> listOfStats = new ArrayList<>();

        @Override
        public void addStats(IStats stats) {
//            listOfStats.add(stats);
            throw new NotImplementedException();
        }

        @Override
        public IAveragePercentOfRangeResult calculateAverage(IStat stat) {
            throw new NotImplementedException();
        }

        public IStats getLastStatsAdded(){
            // return listOfStats.get(0);
            throw new NotImplementedException();
        }
    }
}
