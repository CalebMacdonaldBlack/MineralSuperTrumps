package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public abstract class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isBetterThan(Category category);


    public enum Categories {
        CLEAVAGE("Cleavage"),
        CRUSTAL_ABUNDANCE("Crustal abundance"),
        ECONOMIC_VALUE("Economic value"),
        HARDNESS("Hardness"),
        SPECIFIC_GRAVITY("Specific gravity");

        private final String name;

        Categories(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
