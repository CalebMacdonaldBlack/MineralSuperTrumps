package cmblack.card;

import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ICategoryComparisonResult {
    int cleavage();
    int crustalAbundance();
    int economicValue();
    double hardness();
    double specificGravity();
    boolean equals(ICategoryComparisonResult categoryComparisonResult);
    double valueForCategory(ICategory category);

    class FakeCategoryComparisonResult implements ICategoryComparisonResult{

        @Override
        public int cleavage() {
            return 0;
        }

        @Override
        public int crustalAbundance() {
            return 1;
        }

        @Override
        public int economicValue() {
            return -1;
        }

        @Override
        public double hardness() {
            return 2;
        }

        @Override
        public double specificGravity() {
            return -2;
        }

        @Override
        public boolean equals(ICategoryComparisonResult categoryComparisonResult) {
            return categoryComparisonResult.cleavage() == this.cleavage()
                && categoryComparisonResult.crustalAbundance() == this.crustalAbundance()
                && categoryComparisonResult.economicValue() == this.economicValue()
                && categoryComparisonResult.hardness() == this.hardness()
                && categoryComparisonResult.specificGravity() == this.specificGravity();
        }

        @Override
        public double valueForCategory(ICategory category) {
            return 0;
        }
    }
}
