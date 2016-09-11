package cmblack.card.stats;

import cmblack.card.stats.statscalculator.AveragePercentOfRangeResult;
import cmblack.card.stats.statscalculator.IAveragePercentOfRangeResult;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class AveragePercentOfRangeResultTest {

    IAveragePercentOfRangeResult averagePercentOfRangeResult = new AveragePercentOfRangeResult(10, 20, 30, 40 ,50);

    @Test
    public void testHardnessAveragePercentOfRange() throws Exception {
        assertEquals(10, averagePercentOfRangeResult.hardnessAveragePercentOfRange(), 0);
    }

    @Test
    public void testCleavageAveragePercentOfRange() throws Exception {
        assertEquals(20, averagePercentOfRangeResult.cleavageAveragePercentOfRange(), 0);
    }

    @Test
    public void testCrustalAbundanceAveragePercentOfRange() throws Exception {
        assertEquals(30, averagePercentOfRangeResult.crustalAbundanceAveragePercentOfRange(), 0);
    }

    @Test
    public void testEconomicValueAveragePercentOfRange() throws Exception {
        assertEquals(40, averagePercentOfRangeResult.economicValueAveragePercentOfRange(), 0);
    }

    @Test
    public void testSpecificGravityAveragePercentOfRange() throws Exception {
        assertEquals(50, averagePercentOfRangeResult.specificGravityAveragePercentOfRange(), 0);
    }
}