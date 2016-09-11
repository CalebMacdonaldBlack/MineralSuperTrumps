package cmblack.category.specificgravity;

import cmblack.IRange;
import cmblack.Range;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 11/09/2016.
 */
public class SpecificGravityCategory implements ICategory {


    @Override
    public String getCategoryName() {
        return "Specific gravity";
    }

    @Override
    public IRange getValueRange() {
        return new Range(2.2, 19.3);
    }

    @Override
    public boolean equals(ICategory category) {
        return this.getCategoryName().equals(category.getCategoryName())
            && this.getValueRange().equals(category.getValueRange());
    }
}
