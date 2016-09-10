package cmblack.category.crustalabundance;

import cmblack.category.Category;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CrustalAbundanceBuilder implements ICrustalAbundanceBuilder {
    @Override
    public ICrustalAbundance build(String value, String categoryName) {
        ICategory category = new Category(categoryName);
        switch (value){
            case "ultratrace":
                return new CrustalAbundance(category, CrustalAbundanceValue.ULTRATRACE);
            case "trace":
                return new CrustalAbundance(category, CrustalAbundanceValue.TRACE);
            case "low":
                return new CrustalAbundance(category, CrustalAbundanceValue.LOW);
            case "moderate":
                return new CrustalAbundance(category, CrustalAbundanceValue.MODERATE);
            case "high":
                return new CrustalAbundance(category, CrustalAbundanceValue.HIGH);
            case "very high":C
                return new CrustalAbundance(category, CrustalAbundanceValue.VERY_HIGH);
            default:
                throw new NullPointerException("CrustalAbundance getValue for " + value + " is not found");
        }
    }

    @Override
    public ICrustalAbundance build(String value) {
        return this.build(value, "Crustal abundance");
    }
}
