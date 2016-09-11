package cmblack.category.crustalabundance;

import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface ICrustalAbundanceBuilder {
    ICrustalAbundance build(String value, ICategory category);
    ICrustalAbundance build(String value);

    class FakeCrustalAbundanceBuilder implements ICrustalAbundanceBuilder{

        @Override
        public ICrustalAbundance build(String value, ICategory category) {
            return new ICrustalAbundance.FakeGoodCrustalAbundance();
        }

        @Override
        public ICrustalAbundance build(String value) {
            return this.build(value, new ICategory.FakeCrustalAbundanceCategory());
        }
    }
}
