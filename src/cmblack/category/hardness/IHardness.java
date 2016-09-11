package cmblack.category.hardness;

import cmblack.category.ICategory;
import cmblack.category.IStat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface IHardness extends IStat {
    double getMinimumValue();
    double getMaximumValue();
    ICategory getCategory();
    boolean equals(IHardness hardness);

    public class FakeHardness implements IHardness {

        @Override
        public double getMinimumValue() {
            return 1.2;
        }

        @Override
        public double getMaximumValue() {
            return 1.7;
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeHardnessCategory();
        }

        @Override
        public boolean equals(IHardness hardness) {
            return this.getMinimumValue() == hardness.getMinimumValue()
                && this.getMaximumValue() == hardness.getMaximumValue()
                && this.getCategory().equals(hardness.getCategory());
        }
    }

    class FakeGoodHardness implements IHardness {

        @Override
        public double getMinimumValue() {
            return 3.5;
        }

        @Override
        public double getMaximumValue() {
            return 4.1;
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeHardnessCategory();
        }

        @Override
        public boolean equals(IHardness hardness) {
            return this.getMinimumValue() == hardness.getMinimumValue()
                    && this.getMaximumValue() == hardness.getMaximumValue()
                    && this.getCategory().equals(hardness.getCategory());
        }
    }

    class FakeBadHardness implements IHardness {

        @Override
        public double getMinimumValue() {
            return 0.5;
        }

        @Override
        public double getMaximumValue() {
            return 1;
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeHardnessCategory();
        }

        @Override
        public boolean equals(IHardness hardness) {
            return this.getMinimumValue() == hardness.getMinimumValue()
                    && this.getMaximumValue() == hardness.getMaximumValue()
                    && this.getCategory().equals(hardness.getCategory());
        }
    }
}
