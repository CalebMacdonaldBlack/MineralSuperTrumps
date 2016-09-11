package cmblack.category.economicvalue;

import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IEconomicValueBuilder {
    IEconomicValue build(String value, ICategory category);
    IEconomicValue build(String value);

    class FakeEconomicValue implements IEconomicValueBuilder{

        @Override
        public IEconomicValue build(String value, ICategory category) {
            return new IEconomicValue.FakeGoodEconomicValue();
        }

        @Override
        public IEconomicValue build(String value) {
            return this.build(value, new ICategory.FakeEconomicValueCategory());
        }
    }
}
