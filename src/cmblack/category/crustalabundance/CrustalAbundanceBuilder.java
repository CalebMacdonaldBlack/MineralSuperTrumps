package cmblack.category.crustalabundance;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CrustalAbundanceBuilder implements ICrustalAbundanceBuilder {
    @Override
    public ICrustalAbundance build(String value, String categoryName) {
        return null;
    }

    @Override
    public ICrustalAbundance build(String value) {
        return this.build(value, "Crustal abundance");
    }
}
