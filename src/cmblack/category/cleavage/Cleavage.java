package cmblack.category.cleavage;

import cmblack.category.Category;
import cmblack.category.ICategory;
import cmblack.category.IStat;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class Cleavage implements ICleavage {

    private final ICategory category;
    private final CleavageValue cleavageValue;


    public Cleavage(ICategory category, CleavageValue cleavageValue) {
        this.category = category;
        this.cleavageValue = cleavageValue;
    }

    public Cleavage(CleavageValue cleavageValue) {
        this(new Category("Cleavage"), cleavageValue);
    }

    @Override
    public CleavageValue getValue() {
        return this.cleavageValue;
    }

    @Override
    public boolean equals(ICleavage cleavage) {
        return this.getValue() == cleavage.getValue()
            && this.getCategory().equals(cleavage.getCategory());
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }

    @Override
    public boolean isBetterThan(IStat stat) {
        return false;
    }
}
