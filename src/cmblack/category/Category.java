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

        public static String[] getCategoriesAsStringArray(){
            String[] categoriesAsStringArray = new String[Categories.values().length];
            for(int i=0;i<Categories.values().length;i++){
                categoriesAsStringArray[i] = Categories.values()[i].getName();
            }
            return categoriesAsStringArray;
        }
    }
}
