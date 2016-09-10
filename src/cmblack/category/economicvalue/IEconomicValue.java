package cmblack.category.economicvalue;

import cmblack.category.ICategory;
import cmblack.category.IStat;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IEconomicValue extends IStat {
    EconomicValueValue getValue();
    boolean equals(IEconomicValue economicValue);

    class FakeEconomicValue implements IEconomicValue {

        @Override
        public EconomicValueValue getValue() {
            return EconomicValueValue.HIGH;
        }

        @Override
        public boolean equals(IEconomicValue economicValue) {
            return this.getValue() == economicValue.getValue()
                && this.getCategory().equals(economicValue.getCategory());
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeEconomicValueCategory();
        }
    }
    class FakeEconomicValue2 implements IEconomicValue {

        @Override
        public EconomicValueValue getValue() {
            return EconomicValueValue.LOW;
        }

        @Override
        public boolean equals(IEconomicValue economicValue) {
            return this.getValue() == economicValue.getValue()
                    && this.getCategory().equals(economicValue.getCategory());
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeEconomicValueCategory();
        }
    }
}
