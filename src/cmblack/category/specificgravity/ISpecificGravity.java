package cmblack.category.specificgravity;

import cmblack.category.ICategory;
import cmblack.category.IStat;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ISpecificGravity extends IStat {
    double getMinimumValue();
    double getMaximumValue();
    ICategory getCategory();
    boolean equals(ISpecificGravity specificGravity);

    class FakeSpecificGravity implements ISpecificGravity {

        @Override
        public double getMinimumValue() {
            return 2.3;
        }

        @Override
        public double getMaximumValue() {
            return 2.7;
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeSpecificGravityCategory();
        }

        @Override
        public boolean equals(ISpecificGravity specificGravity) {
            return this.getMinimumValue() == specificGravity.getMinimumValue()
                && this.getMaximumValue() == specificGravity.getMaximumValue()
                && this.getCategory().equals(specificGravity.getCategory());
        }

        @Override
        public boolean isBetterThan(IStat stat) {
            return false;
        }
    }

    class FakeSpecificGravity2 implements ISpecificGravity {

        @Override
        public double getMinimumValue() {
            return 2.8;
        }

        @Override
        public double getMaximumValue() {
            return 3.4;
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeSpecificGravityCategory();
        }

        @Override
        public boolean equals(ISpecificGravity specificGravity) {
            return this.getMinimumValue() == specificGravity.getMinimumValue()
                    && this.getMaximumValue() == specificGravity.getMaximumValue()
                    && this.getCategory().equals(specificGravity.getCategory());
        }

        @Override
        public boolean isBetterThan(IStat stat) {
            return false;
        }
    }
}
