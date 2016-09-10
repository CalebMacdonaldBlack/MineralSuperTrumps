package cmblack.category.crustalabundance;

import cmblack.category.EmptyCategory;
import cmblack.category.ICategory;
import cmblack.category.crustalabundance.CrustalAbundanceValue;
import cmblack.category.crustalabundance.ICrustalAbundance;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyCrustalAbundance implements ICrustalAbundance {
    @Override
    public CrustalAbundanceValue getValue() {
        return CrustalAbundanceValue.EMPTYCARD;
    }

    @Override
    public boolean equals(ICrustalAbundance crustalAbundance) {
        return crustalAbundance.getValue().equals(CrustalAbundanceValue.EMPTYCARD)
            && crustalAbundance.getCategory().equals(this.getCategory());
    }

    @Override
    public ICategory getCategory() {
        return new EmptyCategory();
    }
}
