package cmblack.category.economicvalue;

import cmblack.EmptyRange;
import cmblack.category.Category;
import cmblack.deck.deckbuilder.IParsedCard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EconomicValueBuilderTest {

    IEconomicValueBuilder economicValueBuilder = new EconomicValueBuilder();
    IParsedCard parsedCard = new IParsedCard.FakeParsedCard();

    @Test
    public void testBuild() throws Exception {
        IEconomicValue economicValue = economicValueBuilder.build(parsedCard.getEconomic_value());
        assertEquals("low", economicValue.getValue().getText());
    }

    @Test
    public void testBuild1() throws Exception {
        IEconomicValue economicValue = economicValueBuilder.build(parsedCard.getEconomic_value(), new Category("ecoval", new EmptyRange()));
        assertEquals("ecoval", economicValue.getCategory().getCategoryName());
    }
}