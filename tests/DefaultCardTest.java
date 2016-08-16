import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class DefaultCardTest {

    @org.junit.Test
    public void testGetHeading() throws Exception {
        DefaultCard defaultCard = new DefaultCard("Heading", "Sub Heading");
        assertEquals("Heading", defaultCard.getHeading());
    }

    @org.junit.Test
    public void testGetSubHeading() throws Exception {
        DefaultCard defaultCard = new DefaultCard("Heading", "Sub Heading");
        assertEquals("Sub Heading", defaultCard.getSubHeading());
    }
}