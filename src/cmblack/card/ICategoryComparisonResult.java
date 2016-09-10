package cmblack.card;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ICategoryComparisonResult {
    boolean cleavage();
    boolean crustalAbundance();
    boolean economicValue();
    boolean hardness();
    boolean specificGravity();
    boolean equals(ICategoryComparisonResult categoryComparisonResult);

    class FakeCategoryComparisonResult implements ICategoryComparisonResult{

        @Override
        public boolean cleavage() {
            return false;
        }

        @Override
        public boolean crustalAbundance() {
            return false;
        }

        @Override
        public boolean economicValue() {
            return false;
        }

        @Override
        public boolean hardness() {
            return false;
        }

        @Override
        public boolean specificGravity() {
            return false;
        }

        @Override
        public boolean equals(ICategoryComparisonResult categoryComparisonResult) {
            return categoryComparisonResult.cleavage() == this.cleavage()
                && categoryComparisonResult.crustalAbundance() == this.crustalAbundance()
                && categoryComparisonResult.economicValue() == this.economicValue()
                && categoryComparisonResult.hardness() == this.hardness()
                && categoryComparisonResult.specificGravity() == this.specificGravity();
        }
    }
}
