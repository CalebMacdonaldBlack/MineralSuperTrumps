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

        assertEquals(0, averagePercentOfRangeResult.specificGravityAveragePercentOfRange(), 0);
        assertEquals(0, averagePercentOfRangeResult.economicValueAveragePercentOfRange(), 0);
        assertEquals(0, averagePercentOfRangeResult.crustalAbundanceAveragePercentOfRange(), 0);
        assertEquals(0, averagePercentOfRangeResult.cleavageAveragePercentOfRange(), 0);
        assertEquals(0, averagePercentOfRangeResult.hardnessAveragePercentOfRange(), 0);
    }
}