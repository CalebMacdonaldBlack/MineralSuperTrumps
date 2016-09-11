package cmblack.category.cleavage;

import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ICleavageBuilder {
    ICleavage build(String value);
    ICleavage build(String value, ICategory category);

    class FakeCleavageBuilder implements ICleavageBuilder {

        @Override
        public ICleavage build(String value) {
            return this.build(value, new CleavageCategory());
        }

        @Override
        public ICleavage build(String value, ICategory category) {
            return new ICleavage.FakeCleavage();
        }
    }
}
