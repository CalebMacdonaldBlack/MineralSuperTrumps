package cmblack.category.cleavage;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CleavageBuilder implements ICleavageBuilder {
    @Override
    public ICleavage build(String value) {
        return this.build(value, "Cleavage");
    }

    @Override
    public ICleavage build(String value, String categoryName) {
        return null;
    }
}
