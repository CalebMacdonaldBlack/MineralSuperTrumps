import cmblack.cards.DefaultTrumpCard;
import cmblack.category.DefaultTrumpCategory;
import cmblack.cards.TrumpCard;
import cmblack.category.TrumpCategory;

import static org.junit.Assert.*;
/**
 * Created by calebmacdonaldblack on 16/08/2016.
 */
public class DefaultTrumpCardTest {

    @org.junit.Test
    public void testGetTrumpCategory(){
        TrumpCategory trumpCategory = new DefaultTrumpCategory("Economic Value");
        TrumpCard trumpCard = new DefaultTrumpCard("Heading", "SubHeading", trumpCategory);
        assertEquals(trumpCategory, trumpCard.getTrumpCategory());
    }
}
