package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public enum Categories {
        CLEAVAGE(new Category("Cleavage")),
        CRUSTAL_ABUNDANCE(new Category("Crustal abundance")),
        ECONOMIC_VALUE(new Category("Economic value")),
        HARDNESS(new Category("Hardness")),
        SPECIFIC_GRAVITY(new Category("Specific gravity"));

        private final Category category;

        Categories(Category category) {
            this.category = category;
        }

        public Category getCategory() {
            return category;
        }
    }
}
