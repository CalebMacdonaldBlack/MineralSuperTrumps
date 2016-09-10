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
    }
}
