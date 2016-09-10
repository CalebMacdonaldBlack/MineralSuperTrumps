package cmblack.category.economicvalue;

import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyEconomicValue implements IEconomicValue {
    @Override
    public EconomicValueValue getValue() {
        return EconomicValueValue.EMPTYCARD;
    }

    @Override
    public boolean equals(IEconomicValue economicValue) {
        return economicValue.getValue().equals(EconomicValueValue.EMPTYCARD)
            && economicValue.getCategory().equals(new EmptyCategory());
    }

    @Override
    public ICategory getCategory() {
        return new EmptyCategory();
    }
}
