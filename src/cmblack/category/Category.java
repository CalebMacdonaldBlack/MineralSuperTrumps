package cmblack.category;

import cmblack.IRange;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class Category implements ICategory {

    private final String categoryName;
    private final IRange valueRange;

    public Category(String categoryName, IRange valueRange) {
        this.categoryName = categoryName;
        this.valueRange = valueRange;
    }

    @Override
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override
    public IRange getValueRange() {
        return this.valueRange;
    }

    @Override
    public boolean equals(ICategory category) {
        return this.getCategoryName().equals(category.getCategoryName());
    }
}
