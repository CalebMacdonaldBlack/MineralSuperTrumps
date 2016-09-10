package cmblack.category.cleavage;

import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyCleavage implements ICleavage {
    @Override
    public CleavageValue getValue() {
        return CleavageValue.EMPTYCARD;
    }

    @Override
    public boolean equals(ICleavage cleavage) {
        return cleavage.getValue().equals(CleavageValue.EMPTYCARD)
            && cleavage.getCategory().equals(new EmptyCategory());
    }

    @Override
    public ICategory getCategory() {
        return new EmptyCategory();
    }
}
