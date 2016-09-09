package cmblack.category.specificgravity;

import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.category.IStat;
import cmblack.category.specificgravity.ISpecificGravity;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class SpecificGravity implements ISpecificGravity {

    private final double minimumValue, maximumValue;
    private final ICategory category;

    public SpecificGravity(double minimumValue, double maximumValue, ICategory category) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.category = category;
    }

    public SpecificGravity(double minimumValue, double maximumValue) {
        this(minimumValue, maximumValue, new Category("Specific gravity"));
    }

    @Override
    public double getMinimumValue() {
        return this.minimumValue;
    }

    @Override
    public double getMaximumValue() {
        return this.maximumValue;
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }

    @Override
    public boolean equals(ISpecificGravity specificGravity) {
        return this.getMinimumValue() == specificGravity.getMinimumValue()
            && this.getMaximumValue() == specificGravity.getMaximumValue()
            && this.category.equals(specificGravity.getCategory());
    }

    @Override
    public boolean isBetterThan(IStat stat) {
        return false;
    }
}