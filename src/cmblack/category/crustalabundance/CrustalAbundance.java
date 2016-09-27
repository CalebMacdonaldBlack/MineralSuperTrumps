package cmblack.category.crustalabundance;

import cmblack.category.Category;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class CrustalAbundance implements ICrustalAbundance {
    private final ICategory category;
    private final CrustalAbundanceValue value;

    public CrustalAbundance(ICategory category, CrustalAbundanceValue value) {
        this.category = category;
        this.value = value;
    }

    public CrustalAbundance(CrustalAbundanceValue value) {
        this(new CrustalAbundanceCategory(), value);
    }

    @Override
    public CrustalAbundanceValue getValue() {
        return this.value;
    }

    @Override
    public boolean equals(ICrustalAbundance crustalAbundance) {
        return this.value == crustalAbundance.getValue()
            && this.category.equals(crustalAbundance.getCategory());
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }

    @Override
    public String toString(){
        return
                category.getCategoryName() + "\t- " + value.getText();
    }
}
