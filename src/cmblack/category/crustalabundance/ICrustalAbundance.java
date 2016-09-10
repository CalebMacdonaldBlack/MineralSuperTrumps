package cmblack.category.crustalabundance;

import cmblack.category.ICategory;
import cmblack.category.IStat;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ICrustalAbundance extends IStat {
    CrustalAbundanceValue getValue();
    boolean equals(ICrustalAbundance crustalAbundance);

    class FakeCrustalAbundance implements ICrustalAbundance {

        @Override
        public CrustalAbundanceValue getValue() {
            return CrustalAbundanceValue.HIGH;
        }

        @Override
        public boolean equals(ICrustalAbundance crustalAbundance) {
            return this.getValue() == crustalAbundance.getValue()
                && this.getCategory().equals(crustalAbundance.getCategory());
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeCrustalAbundanceCategory();
        }
    }

    class FakeCrustalAbundance2 implements ICrustalAbundance {

        @Override
        public CrustalAbundanceValue getValue() {
            return CrustalAbundanceValue.LOW;
        }

        @Override
        public boolean equals(ICrustalAbundance crustalAbundance) {
            return this.getValue() == crustalAbundance.getValue()
                    && this.getCategory().equals(crustalAbundance.getCategory());
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeCrustalAbundanceCategory();
        }
    }
}
