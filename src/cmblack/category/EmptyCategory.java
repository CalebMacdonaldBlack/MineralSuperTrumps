package cmblack.category;

import cmblack.range.EmptyRange;
import cmblack.range.IRange;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyCategory implements ICategory {
    @Override
    public String getCategoryName() {
        return "";
    }

    @Override
    public IRange getValueRange() {
        return new EmptyRange();
    }

    @Override
    public boolean equals(ICategory category) {
        return category.getCategoryName().equals("");
    }
}
