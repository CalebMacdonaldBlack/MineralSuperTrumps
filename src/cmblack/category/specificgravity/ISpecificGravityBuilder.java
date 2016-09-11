package cmblack.category.specificgravity;

import cmblack.IRange;
import cmblack.Range;
import cmblack.category.ICategory;
import cmblack.category.hardness.IHardness;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ISpecificGravityBuilder {
    ISpecificGravity build(String value, ICategory category);
    ISpecificGravity build(String value);

    class FakeSpecificGravityBuilder implements ISpecificGravityBuilder{

        @Override
        public ISpecificGravity build(String value, ICategory category) {
            return new ISpecificGravity.FakeSpecificGravity();
        }

        @Override
        public ISpecificGravity build(String value) {
            return this.build(value, new ICategory.FakeSpecificGravityCategory());
        }
    }
}
