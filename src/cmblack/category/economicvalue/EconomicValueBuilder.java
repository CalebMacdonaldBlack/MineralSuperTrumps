package cmblack.category.economicvalue;

import cmblack.category.Category;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EconomicValueBuilder implements IEconomicValueBuilder {
    @Override
    public IEconomicValue build(String value, String categoryName) {
        ICategory category = new Category(categoryName);
        switch (value){
            case "trivial":
                return new EconomicValue(EconomicValueValue.TRIVIAL, category);
            case "low":
                return new EconomicValue(EconomicValueValue.LOW, category);
            case "moderate":
                return new EconomicValue(EconomicValueValue.MODERATE, category);
            case "high":
                return new EconomicValue(EconomicValueValue.HIGH, category);
            case "very high":
                return new EconomicValue(EconomicValueValue.VERY_HIGH, category);
            case "I'm rich!":
                return new EconomicValue(EconomicValueValue.IM_RICH, category);
            default:
                throw new NullPointerException("EconomicValue getValue for " + value + " is not found");
        }
    }

    @Override
    public IEconomicValue build(String value) {
        return this.build(value, "Economic value");
    }
}
