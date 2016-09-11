package cmblack.category.hardness;

import cmblack.category.Category;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class HardnessBuilder implements IHardnessBuilder {
    @Override
    public IHardness build(String value, ICategory category) {
        return new Hardness(
                this.getLowFromRangeString(value),
                this.getHighFromRangeString(value),
                category
        );
    }

    @Override
    public IHardness build(String value) {
        return this.build(value, new HardnessCategory());
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
