package cmblack.category.crustalabundance;

import cmblack.category.ICategory;
import cmblack.category.IStat;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ICrustalAbundance extends IStat {
    int getValue();
    String getValueName();
    boolean equals(ICrustalAbundance crustalAbundance);

    class FakeCrustalAbundance implements ICrustalAbundance {

        @Override
        public int getValue() {
            return 4;
        }

        @Override
        public String getValueName() {
            return "high";
        }

        @Override
        public boolean equals(ICrustalAbundance crustalAbundance) {
            return this.getValue() == crustalAbundance.getValue()
                && this.getValueName().equals(crustalAbundance.getValueName())
                && this.getCategory().equals(crustalAbundance.getCategory());
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeCrustalAbundanceCategory();
        }

        @Override
        public boolean isBetterThan(IStat stat) {
            return false;
        }
    }
}
