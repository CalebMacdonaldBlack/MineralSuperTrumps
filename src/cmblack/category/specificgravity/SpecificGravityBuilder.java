package cmblack.category.specificgravity;

import cmblack.category.Category;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class SpecificGravityBuilder implements ISpecificGravityBuilder {
    @Override
    public ISpecificGravity build(String value, String categoryName) {
        ICategory category = new Category(categoryName);
        return new SpecificGravity(
                this.getLowFromRangeString(value),
                this.getHighFromRangeString(value),
                category
                );
    }

    @Override
    public ISpecificGravity build(String value) {
        return this.build(value, "Specific gravity");
    }

    //TODO duplicate code: remove this
    private Double getLowFromRangeString(String doubleRange) {
        return Double.parseDouble(doubleRange.split("-")[0]);
    }

    //TODO duplicate code: remove this
    private Double getHighFromRangeString(String doubleRange) {
        String[] splitDouble = doubleRange.split("-");
        return splitDouble.length > 1 ? Double.parseDouble(splitDouble[1]) : Double.parseDouble(splitDouble[0]);
    }
}