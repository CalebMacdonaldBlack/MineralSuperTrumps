package cmblack.card.stats;

import cmblack.category.IStat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public interface IAveragePercentOfRangeCalculator {
    void addStats(IStats stat);
    IAveragePercentOfRangeResult calculateAverage();

    class FakeAveragePercentOfRangeCalculator implements IAveragePercentOfRangeCalculator {

        @Override
        public void addStats(IStats stats) {
        }

        @Override
        public IAveragePercentOfRangeResult calculateAverage() {
            return new IAveragePercentOfRangeResult.FakeAveragePercentOfRangeResult();
        }
    }
}
