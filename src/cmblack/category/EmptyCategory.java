package cmblack.category;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class EmptyCategory implements ICategory {
    @Override
    public String getCategoryName() {
        return "";
    }

    @Override
    public boolean equals(ICategory category) {
        return category.getCategoryName().equals("");
    }
}
