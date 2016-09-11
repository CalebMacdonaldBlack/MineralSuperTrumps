package cmblack.category.economicvalue;

import cmblack.category.Category;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 23/08/2016.
 */
public class EconomicValue implements IEconomicValue {
    private final EconomicValueValue value;
    private final ICategory category;

    public EconomicValue(EconomicValueValue value, ICategory category) {
        this.value = value;
        this.category = category;
    }

    public EconomicValue(EconomicValueValue value) {
        this(value, new EconomicValueCategory());
    }


    @Override
    public EconomicValueValue getValue() {
        return this.value;
    }

    @Override
    public boolean equals(IEconomicValue economicValue) {
        return this.value == economicValue.getValue()
            && this.category.equals(economicValue.getCategory());
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }
}
