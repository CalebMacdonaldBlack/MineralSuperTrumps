package cmblack.category;

/**
 * Created by calebmacdonaldblack on 9/09/2016.
 */
public class Cleavage implements ICleavage {

    private final int value;
    private final String valueName;
    private final ICategory category;

    public Cleavage(int value, String valueName, ICategory category) {
        this.value = value;
        this.valueName = valueName;
        this.category = category;
    }

    public Cleavage(int value, String valueName) {
        this(value, valueName, new Category("Cleavage"));
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getValueName() {
        return this.valueName;
    }

    @Override
    public boolean equals(ICleavage cleavage) {
        return this.getValue() == cleavage.getValue()
            && this.getValueName().equals(cleavage.getValueName())
            && this.getCategory().equals(cleavage.getCategory());
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }

    @Override
    public boolean isBetterThan(IStat stat) {
        return false;
    }
}
