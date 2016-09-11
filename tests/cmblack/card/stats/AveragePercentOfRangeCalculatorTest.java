package cmblack.card.stats;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class AveragePercentOfRangeCalculatorTest {

    @Test
    public void testAddStats() throws Exception {

    }

    @Test
    public void testCalculateAverage() throws Exception {
        IAveragePercentOfRangeCalculator averagePercentOfRangeCalculator = new AveragePercentOfRangeCalculator();

        averagePercentOfRangeCalculator.addStats(new IStats.FakeGoodPlayCardStats());
        averagePercentOfRangeCalculator.addStats(new IStats.FakeGoodPlayCardStats());

        IAveragePercentOfRangeResult averagePercentOfRangeResult = averagePercentOfRangeCalculator.calculateAverage();

        assertEquals(22, (int)averagePercentOfRangeResult.specificGravityAveragePercentOfRange());
        assertEquals(66, (int)averagePercentOfRangeResult.economicValueAveragePercentOfRange());
        assertEquals(83, (int)averagePercentOfRangeResult.crustalAbundanceAveragePercentOfRange());
        assertEquals(92, (int)averagePercentOfRangeResult.cleavageAveragePercentOfRange());
        assertEquals(34, (int)averagePercentOfRangeResult.hardnessAveragePercentOfRange());
    }
}