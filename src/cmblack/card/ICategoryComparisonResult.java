package cmblack.card;

import cmblack.category.cleavage.ICleavage;
import cmblack.category.crustalabundance.ICrustalAbundance;
import cmblack.category.economicvalue.IEconomicValue;
import cmblack.category.hardness.IHardness;
import cmblack.category.specificgravity.ISpecificGravity;

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
