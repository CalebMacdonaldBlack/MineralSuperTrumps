package cmblack.category.economicvalue;

import cmblack.IRange;
import cmblack.Range;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class EconomicValueCategory implements ICategory {
    @Override
    public String getCategoryName() {
        return "Economic value";
    }

    @Override
    public IRange getValueRange() {
        return new Range(1, 7);
    }

    @Override
    public boolean equals(ICategory category) {
        return this.getCategoryName().equals(category.getCategoryName())
            && this.getValueRange().equals(category.getValueRange());
    }
}
