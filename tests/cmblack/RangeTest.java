package cmblack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class RangeTest {

    IRange range = new Range(6, 10);

    @Test
    public void testMinValue() throws Exception {
        assertEquals(6, range.minValue(), 0);
    }

    @Test
    public void testMaxValue() throws Exception {
        assertEquals(10, range.maxValue(), 0);
    }

    @Test
    public void testPercentageOfValueInRange() throws Exception {
        assertEquals(50, range.percentageOfValueInRange(8), 0);
    }
}