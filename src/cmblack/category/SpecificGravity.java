package cmblack.category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class SpecificGravity extends Category {
    private final double rangeLow, rangeHigh;

    public SpecificGravity(double rangeLow, double rangeHigh) {
        this("Specific gravity", rangeLow, rangeHigh);
    }

    public SpecificGravity(String name, double rangeLow, double rangeHigh) {
        super(name);
        this.rangeLow = rangeLow;
        this.rangeHigh = rangeHigh;
    }

    public double getRangeLow() {
        return rangeLow;
    }

    public double getRangeHigh() {
        return rangeHigh;
    }

    @Override
    public boolean isBetterThan(Category category) {
        return category instanceof SpecificGravity
                && ((SpecificGravity) category).rangeHigh < rangeHigh;
    }
}
