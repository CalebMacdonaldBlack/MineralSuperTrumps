package cmblack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class EmptyRangeTest {

    @Test
    public void testMinValue() throws Exception {
        assertEquals(0, new EmptyRange().minValue(), 0);
    }

    @Test
    public void testMaxValue() throws Exception {
        assertEquals(0, new EmptyRange().maxValue(), 0);
    }

    @Test
    public void testPercentageOfValueInRange() throws Exception {
        assertEquals(0, new EmptyRange().percentageOfValueInRange(0), 0);
    }
}