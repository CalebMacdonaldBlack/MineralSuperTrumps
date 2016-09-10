package cmblack.category.economicvalue;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EconomicValueBuilder implements IEconomicValueBuilder {
    @Override
    public IEconomicValue build(String value, String categoryName) {
        return null;
    }

    @Override
    public IEconomicValue build(String value) {
        return this.build(value, "Economic value");
    }
}
