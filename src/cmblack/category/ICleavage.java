package cmblack.category;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ICleavage extends IStat{
    int getValue();
    String getValueName();
    boolean equals(ICleavage cleavage);

    class FakeCleavage implements ICleavage{

        @Override
        public int getValue() {
            return 3;
        }

        @Override
        public String getValueName() {
            return "2 poor";
        }

        @Override
        public boolean equals(ICleavage cleavage) {
            return cleavage.getValue() == this.getValue()
                && cleavage.getValueName().equals(this.getValueName());
        }

        @Override
        public ICategory getCategory() {
            return new ICategory.FakeCleavageCategory();
        }

        @Override
        public boolean isBetterThan(IStat stat) {
            throw new NotImplementedException();
        }
    }
}
