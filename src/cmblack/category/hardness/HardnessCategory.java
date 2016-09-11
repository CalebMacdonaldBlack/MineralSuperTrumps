package cmblack.category.hardness;

import cmblack.range.IRange;
import cmblack.range.Range;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class HardnessCategory implements ICategory {
    @Override
    public String getCategoryName() {
        return "Hardness";
    }

    @Override
    public IRange getValueRange() {
        return new Range(1, 10);
    }

    @Override
    public boolean equals(ICategory category) {
        return this.getCategoryName().equals(category.getCategoryName())
            && this.getValueRange().equals(category.getValueRange());
    }
}
