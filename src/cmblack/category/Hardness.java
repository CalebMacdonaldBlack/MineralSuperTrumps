package cmblack.category;

import cmblack.category.Category;

/**
 * Created by calebmacdonaldblack on 22/08/2016.
 */
public class Hardness extends Category {
    private final double rangeLow, rangeHigh;

    public Hardness(double rangeLow, double rangeHigh) {
        this("Hardness", rangeLow, rangeHigh);
    }

    public Hardness(String name, double rangeLow, double rangeHigh) {
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
        if(category instanceof Hardness){
            System.out.println("RAGNE: " + (((Hardness) category).rangeHigh < rangeHigh));
            return ((Hardness) category).rangeHigh < rangeHigh;
        }
        throw new IllegalArgumentException(category.getName() + " is not an instance of " + this.getName());
    }
}
