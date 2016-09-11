package cmblack.category;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public class CategoryComparisonResult implements ICategoryComparisonResult {

    private final int cleavage, crustalAbundance, economicValue;
    private final double hardness, specificGravity;

    public CategoryComparisonResult(int cleavage, int crustalAbundance, int economicValue, double hardness, double specificGravity) {
        this.cleavage = cleavage;
        this.crustalAbundance = crustalAbundance;
        this.economicValue = economicValue;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
    }

    @Override
    public int cleavage() {
        return this.cleavage;
    }

    @Override
    public int crustalAbundance() {
        return this.crustalAbundance;
    }

    @Override
    public int economicValue() {
        return this.economicValue;
    }

    @Override
    public double hardness() {
        return this.hardness;
    }

    @Override
    public double specificGravity() {
        return this.specificGravity;
    }

    @Override
    public boolean equals(ICategoryComparisonResult categoryComparisonResult) {
        return categoryComparisonResult.cleavage() == this.cleavage()
                && categoryComparisonResult.crustalAbundance() == this.crustalAbundance()
                && categoryComparisonResult.economicValue() == this.economicValue()
                && categoryComparisonResult.hardness() == this.hardness()
                && categoryComparisonResult.specificGravity() == this.specificGravity();
    }

    @Override
    public double valueForCategory(ICategory category) {
        //todo dodgyness happening here
        switch(category.getCategoryName()){
            case "Hardness":
                return this.hardness;
            case "Specific gravity":
                return this.specificGravity;
            case "Economic value":
                return this.economicValue;
            case "Cleavage":
                return this.cleavage;
            case "Crustal abundance":
                return this.crustalAbundance;
            default:
                throw new NullPointerException("Cannot find value for the category named: " + category.getCategoryName());
        }
    }
}
