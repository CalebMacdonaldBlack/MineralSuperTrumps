package cmblack.category.cleavage;

import cmblack.category.ICategory;
import cmblack.category.IStat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ICleavage extends IStat {
    CleavageValue getValue();
    boolean equals(ICleavage cleavage);

    class FakeCleavage implements ICleavage{

        @Override
        public CleavageValue getValue() {
            return CleavageValue.GOOD2;
        }

        @Override
        public boolean equals(ICleavage cleavage) {
            return cleavage.getValue() == this.getValue();
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeCleavageCategory();
        }
    }

    class FakeCleavage2 implements ICleavage{

        @Override
        public CleavageValue getValue() {
            return CleavageValue.PERFECT3;
        }

        @Override
        public boolean equals(ICleavage cleavage) {
            return cleavage.getValue() == this.getValue();
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeCleavageCategory();
        }
    }
}
