package cmblack.category.specificgravity;

import cmblack.category.hardness.IHardness;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ISpecificGravityBuilder {
    ISpecificGravity build(String value, String categoryName);
    ISpecificGravity build(String value);

    class FakeSpecificGravityBuilder implements ISpecificGravityBuilder{

        @Override
        public ISpecificGravity build(String value, String categoryName) {
            return new ISpecificGravity.FakeSpecificGravity();
        }

        @Override
        public ISpecificGravity build(String value) {
            return this.build(value, "Specific gravity");
        }
    }
}
