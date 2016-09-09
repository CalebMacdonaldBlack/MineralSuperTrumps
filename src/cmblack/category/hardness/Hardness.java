package cmblack.category.hardness;

import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.category.IStat;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class Hardness implements IHardness {

    private final double minimumValue, maximumValue;
    private final ICategory category;

    public Hardness(double minimumValue, double maximumValue, ICategory category) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.category = category;
    }

    public Hardness(double minimumValue, double maximumValue) {
        this(minimumValue, maximumValue, new Category("Hardness"));
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
    public boolean isBetterThan(IStat stat) {
        return false;
    }

    @Override
    public boolean equals(IHardness hardness) {
        return this.maximumValue == hardness.getMaximumValue()
            && this.minimumValue == hardness.getMinimumValue()
            && this.category.equals(hardness.getCategory());
    }
}
