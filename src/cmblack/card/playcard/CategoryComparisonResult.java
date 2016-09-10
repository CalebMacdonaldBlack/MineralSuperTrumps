package cmblack.card.playcard;

import cmblack.card.ICategoryComparisonResult;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CategoryComparisonResult implements ICategoryComparisonResult {

    private final boolean cleavage, crustalAbundance, economicValue, hardness, specificGravity;

    public CategoryComparisonResult(boolean cleavage, boolean crustalAbundance, boolean economicValue, boolean hardness, boolean specificGravity) {
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
    }

    @Override
    public boolean cleavage() {
        return this.cleavage;
    }

    @Override
    public boolean crustalAbundance() {
        return this.crustalAbundance;
    }

    @Override
    public boolean economicValue() {
        return this.economicValue;
    }

    @Override
    public boolean hardness() {
        return this.hardness;
    }

    @Override
    public boolean specificGravity() {
        return this.specificGravity;
    }
}
