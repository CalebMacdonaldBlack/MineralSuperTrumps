package cmblack.category.hardness;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IHardnessBuilder {
    IHardness build(String value, String categoryName);
    IHardness build(String value);
    class FakeHardnessBuilder implements IHardnessBuilder{

        @Override
        public IHardness build(String value, String categoryName) {
            return new IHardness.FakeHardness();
        }

        @Override
        public IHardness build(String value) {
            return this.build(value, "Hardness");
        }
    }
}
