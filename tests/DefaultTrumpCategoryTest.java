import static org.junit.Assert.*;
/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class DefaultTrumpCategoryTest {

    @org.junit.Test
    public void testGetName(){
        TrumpCategory trumpCategory = new DefaultTrumpCategory("Economic value");
        assertEquals("Economic value", trumpCategory.getName());
    }
}
