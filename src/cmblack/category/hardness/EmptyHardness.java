package cmblack.category.hardness;

import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyHardness implements IHardness {
    @Override
    public double getMinimumValue() {
        return 0;
    }

    @Override
    public double getMaximumValue() {
        return 0;
    }

    @Override
    public ICategory getCategory() {
        return new EmptyCategory();
    }

    @Override
    public boolean equals(IHardness hardness) {
        return hardness.getCategory().equals(new EmptyCategory())
            && hardness.getMaximumValue() == 0
            && hardness.getMinimumValue() == 0;
    }
}
