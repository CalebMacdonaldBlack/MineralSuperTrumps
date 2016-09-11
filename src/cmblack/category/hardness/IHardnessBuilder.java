package cmblack.category.hardness;

import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IHardnessBuilder {
    IHardness build(String value, ICategory category);
    IHardness build(String value);
    class FakeHardnessBuilder implements IHardnessBuilder{

        @Override
        public IHardness build(String value, ICategory category) {
            return new IHardness.FakeHardness();
        }

        @Override
        public IHardness build(String value) {
            return this.build(value, new ICategory.FakeHardnessCategory());
        }
    }
}
