package cmblack.category;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public interface ICategory {
    String getCategoryName();
    boolean equals(ICategory category);

    public class FakeHardnessCategory implements ICategory {

        @Override
        public String getCategoryName() {
            return "Hardness";
        }

        @Override
        public boolean equals(ICategory category) {
            return this.getCategoryName().equals(category.getCategoryName());
        }
    }

    class FakeCategory2 implements ICategory {

        @Override
        public String getCategoryName() {
            return "Cleavage";
        }

        @Override
        public boolean equals(ICategory category) {
            return this.getCategoryName().equals(category.getCategoryName());
        }
    }

    class FakeCleavageCategory implements ICategory {

        @Override
        public String getCategoryName() {
            return "Cleavage";
        }

        @Override
        public boolean equals(ICategory category) {
            return this.getCategoryName().equals(category.getCategoryName());
        }
    }

    class FakeEconomicValueCategory implements ICategory {
        @Override
        public String getCategoryName() {
            return "Economic value";
        }

        @Override
        public boolean equals(ICategory category) {
            return this.getCategoryName().equals(category.getCategoryName());
        }
    }

    class FakeCrustalAbundanceCategory implements ICategory {

        @Override
        public String getCategoryName() {
            return "Crustal abundance";
        }

        @Override
        public boolean equals(ICategory category) {
            return this.getCategoryName().equals(category.getCategoryName());
        }
    }

    class FakeSpecificGravityCategory implements ICategory {

        @Override
        public String getCategoryName() {
            return "Specific gravity";
        }

        @Override
        public boolean equals(ICategory category) {
            return this.getCategoryName().equals(category.getCategoryName());
        }
    }
}
