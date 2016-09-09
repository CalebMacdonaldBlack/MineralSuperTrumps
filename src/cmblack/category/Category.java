package cmblack.category;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class Category implements ICategory {

    private final String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String getCategoryName() {
        return this.categoryName;
    }

    @Override
    public boolean equals(ICategory category) {
        return this.getCategoryName().equals(category.getCategoryName());
    }
}
