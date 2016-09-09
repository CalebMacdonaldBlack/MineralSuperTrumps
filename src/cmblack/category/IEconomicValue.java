package cmblack.category;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IEconomicValue extends IStat {
    int getValue();
    String getValueName();
    boolean equals(IEconomicValue economicValue);

    class FakeEconomicValue implements IEconomicValue {

        @Override
        public int getValue() {
            return 2;
        }

        @Override
        public String getValueName() {
            return "moderate";
        }

        @Override
        public boolean equals(IEconomicValue economicValue) {
            return this.getValue() == economicValue.getValue()
                && this.getValueName().equals(economicValue.getValueName())
                && this.getCategory().equals(economicValue.getCategory());
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeEconomicValueCategory();
        }

        @Override
        public boolean isBetterThan(IStat stat) {
            return false;
        }
    }
}
