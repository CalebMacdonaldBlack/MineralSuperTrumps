package cmblack.category.specificgravity;

import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptySpecificGravity implements ISpecificGravity {
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
    public boolean equals(ISpecificGravity specificGravity) {
        return specificGravity.getCategory().equals(new EmptyCategory())
            && specificGravity.getMaximumValue() == 0
            && specificGravity.getMinimumValue() == 0;
    }
}
