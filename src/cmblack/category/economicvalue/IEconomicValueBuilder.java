package cmblack.category.economicvalue;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IEconomicValueBuilder {
    IEconomicValue build(String value, String categoryName);
    IEconomicValue build(String value);

    class FakeEconomicValue implements IEconomicValueBuilder{

        @Override
        public IEconomicValue build(String value, String categoryName) {
            return new IEconomicValue.FakeGoodEconomicValue();
        }

        @Override
        public IEconomicValue build(String value) {
            return this.build(value, "Economic value");
        }
    }
}
