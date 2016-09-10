package cmblack.category.cleavage;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ICleavageBuilder {
    ICleavage build(String value);
    ICleavage build(String value, String categoryName);

    class FakeCleavageBuilder implements ICleavageBuilder {

        @Override
        public ICleavage build(String value) {
            return this.build(value, "Cleavage");
        }

        @Override
        public ICleavage build(String value, String categoryName) {
            return new ICleavage.FakeCleavage();
        }
    }
}
