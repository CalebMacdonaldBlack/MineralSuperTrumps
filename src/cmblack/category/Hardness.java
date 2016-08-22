package cmblack.category;

import cmblack.category.Category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class Hardness extends Category {
    private CategoryValueRange range;

    public Hardness(String name, CategoryValueRange range) {
        super(name);
        this.range = range;
    }

    public CategoryValueRange getRange() {
        return range;
    }
}
