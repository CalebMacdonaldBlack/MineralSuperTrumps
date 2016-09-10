package cmblack.category.crustalabundance;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ICrustalAbundanceBuilder {
    ICrustalAbundance build(String value, String categoryName);
    ICrustalAbundance build(String value);

    class FakeCrustalAbundanceBuilder implements ICrustalAbundanceBuilder{

        @Override
        public ICrustalAbundance build(String value, String categoryName) {
            return new ICrustalAbundance.FakeCrustalAbundance();
        }

        @Override
        public ICrustalAbundance build(String value) {
            return this.build(value, "Crustal abundance");
        }
    }
}
