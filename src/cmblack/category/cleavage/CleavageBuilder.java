package cmblack.category.cleavage;

import cmblack.category.Category;
import cmblack.category.ICategory;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CleavageBuilder implements ICleavageBuilder {
    @Override
    public ICleavage build(String value) {
        return this.build(value, new CleavageCategory());
    }

    @Override
    public ICleavage build(String value, ICategory category) {;
        switch(value){
            case "none":
                return new Cleavage(category, CleavageValue.NONE);
            case "poor/none":
                return new Cleavage(category, CleavageValue.POOR_NONE);
            case "1 poor":
                return new Cleavage(category, CleavageValue.POOR1);
            case "2 poor":
                return new Cleavage(category, CleavageValue.POOR2);
            case "1 good":
                return new Cleavage(category, CleavageValue.GOOD1);
            case "1 good, 1 poor":
                return new Cleavage(category, CleavageValue.GOOD1_POOR1);
            case "2 good":
                return new Cleavage(category, CleavageValue.GOOD2);
            case "3 good":
                return new Cleavage(category, CleavageValue.GOOD3);
            case "1 perfect":
                return new Cleavage(category, CleavageValue.PERFECT1);
            case "1 perfect, 1 good":
                return new Cleavage(category, CleavageValue.PERFECT1_GOOD1);
            case "1 perfect, 2 good":
                return new Cleavage(category, CleavageValue.PERFECT1_GOOD2);
            case "2 perfect, 1 good":
                return new Cleavage(category, CleavageValue.PERFECT2_GOOD1);
            case "3 perfect":
                return new Cleavage(category, CleavageValue.PERFECT3);
            case "4 perfect":
                return  new Cleavage(category, CleavageValue.PERFECT4);
            case "6 perfect":
                return new Cleavage(category, CleavageValue.PERFECT6);
            default:
                throw new NullPointerException("Cleavage getValue for " + value + " is not found");
        }
    }
}
